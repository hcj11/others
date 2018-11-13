package BoundedTest;

import static BoundedTest.PutTakeTest.xorShift;
import static org.junit.Assert.assertEquals;

import Concurrent.Test.BoundedBuffer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hcj on 18-5-5
 *
 * 有界缓存的 安全性测试 + 性能测试
 */
public class TimedPutTakeTest {

  private final static ExecutorService pool = Executors.newCachedThreadPool();

  // takeSum
  private final AtomicInteger takeSum = new AtomicInteger(0);
  // putSum
  private final AtomicInteger putSum = new AtomicInteger(0);
  private final BoundedBuffer<Integer> bb;
  // 栅栏
  private final CyclicBarrier barrier;
  private final BarrierTimer timer;
  private int nPairs, nTrials;


  public TimedPutTakeTest(int nPairs, int nTrials, int MaxSize) {
    this.timer = new BarrierTimer();
    bb = new BoundedBuffer<Integer>(MaxSize);
    this.nPairs = nPairs;
    this.nTrials = nTrials;
    this.barrier = new CyclicBarrier(2 * nPairs + 1, timer); // 21
  }

  long test() {
    timer.clear();
    try {
      for (int i = 0; i < nPairs; i++) {
        pool.execute(new Provider());
        pool.execute(new Consumer());
      }
      barrier.await(); // 等待所有线程就绪
      barrier.await(); // 等待所有线程执行完成
      long nsPerItem = timer.getTime() / (nPairs * (long) nTrials);
//      System.out.println("Throughput: " + nsPerItem + " ns/item");

      assertEquals(takeSum.get(), putSum.get());
      return nsPerItem;
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }

    return 0;
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
    int tpt = 100000; // 每个线程的测试次数
    for (int cap = 1; cap <= 1000; cap *= 10) {
//      System.out.println("Capacity: " + cap);
      for (int pairs = 1; pairs <= 1280; pairs *= 2) {
        TimedPutTakeTest timedPutTakeTest = new TimedPutTakeTest(cap, pairs, tpt);
//        System.out.println("pairs: " + pairs + "\t");
        long test = timedPutTakeTest.test();

        System.out.println("\t");
        Thread.sleep(1000);

        long test1 = timedPutTakeTest.test();
        long testfinal = (test + test1) / 2;
        System.out.println(testfinal);

//        System.out.println();
        Thread.sleep(1000);


      }
    }

    pool.shutdown();
  }

  private class BarrierTimer implements Runnable {

    private boolean started;
    private long startTime, endTime;

    @Override
    public synchronized void run() {
      long t = System.nanoTime();
      if (!started) {
        started = true;
        startTime = t;
      } else {
        endTime = t;
      }
    }

    public synchronized void clear() {
      started = false;
    }

    public synchronized long getTime() {
      return endTime - startTime;
    }

  }
}
