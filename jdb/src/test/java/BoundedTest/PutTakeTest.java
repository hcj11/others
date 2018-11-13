package BoundedTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Concurrent.Test.BoundedBuffer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有界緩存的安全性测试 Created by hcj on 18-5-5
 */
public class PutTakeTest {

  private final static ExecutorService pool = Executors.newCachedThreadPool();


  // takeSum
  private final AtomicInteger takeSum = new AtomicInteger(0);
  // putSum
  private final AtomicInteger putSum = new AtomicInteger(0);
  private final BoundedBuffer<Integer> bb;
  // 栅栏
  private final CyclicBarrier barrier;
  private int nPairs, nTrials;

  static int xorShift(int y) {
    y ^= (y << 6);
    y ^= (y >>> 21);
    y ^= (y << 7);
    return y;
  }

  public PutTakeTest(int nPairs, int nTrials, int MaxSize) {
    bb = new BoundedBuffer<Integer>(MaxSize);
    this.nPairs = nPairs;
    this.nTrials = nTrials;
    this.barrier = new CyclicBarrier(2 * nPairs + 1); // 21
  }

  void test()  {
    for (int i = 0; i < nPairs; i++) {
      pool.execute(new Provider());
      pool.execute(new Consumer());
    }
    try {
      barrier.await(); // 等待所有线程就绪
      barrier.await(); // 等待所有线程执行完成
      System.out.println(takeSum.get());
      System.out.println(putSum.get());
      assertEquals(takeSum.get(), putSum.get());

    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }


  }

  class Provider implements Runnable {

    @Override
    public void run() {
      // 保证当前seed的不重复
      int seed = (this.hashCode() ^ (int) System.nanoTime());
      int sum = 0;
      try {
        barrier.await();

        for (int i = nTrials; i > 0; --i) {
          bb.put(seed);
          sum += seed;
          seed = xorShift(seed);
        }
        putSum.getAndAdd(sum);
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  class Consumer implements Runnable {

    @Override
    public void run() {
      int sum = 0;
      try {
        barrier.await();
        for (int i = nTrials; i > 0; --i) {

          int take = bb.take();
          sum += take;
        }
        takeSum.getAndAdd(sum);
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }


  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    new PutTakeTest(50, 10, 10000).test();
    // 为啥线程池无法停止执行， 待确定
//     pool.awaitTermination(1000L, TimeUnit.MILLISECONDS);
    pool.shutdown();
  }
}
