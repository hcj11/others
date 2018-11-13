package Concurrent.question2.finishCode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 栅栏 Created by hcj on 18-5-27 + BlockingQueue 做容器
 */
public class barriers {

  private final static ExecutorService pool = Executors.newCachedThreadPool();


  // takeSum
  private final AtomicInteger takeSum = new AtomicInteger(0);
  // putSum
  private final AtomicInteger putSum = new AtomicInteger(0);
  private final BlockingQueue<Integer> bb;
  // 栅栏 provider
  private final CyclicBarrier providerbarrier;
  // 栅栏 consumer
  private final CyclicBarrier consumerbarrier;
  private int nPairs, nTrials;

  static int xorShift() {
    // [0,1) -> [0,9] -> [1,10)
    int y = 10;
    return (int) (Math.random() * y) + 1;

  }

  public barriers(int nPairs, int nTrials, int MaxSize) {
    bb = new LinkedBlockingQueue<Integer>();
    this.nPairs = nPairs; // 5 个 provider and 5 个 consumer
    this.nTrials = nTrials; // 200   => 5 * 200=1000个整数
    this.providerbarrier = new CyclicBarrier(nPairs / 2 + 1); // 6
    this.consumerbarrier = new CyclicBarrier(nPairs / 2 + 1); // 6

  }

  void test(barriers barriers) {

    for (int i = 1; i <= barriers.nPairs; i++) {
      if (i % 2 != 0) {
        pool.execute(new Provider(barriers));
      } else {
        pool.execute(new Consumer(barriers));
      }
    }

    try {
      barriers.providerbarrier.await(); // 等待所有生产者线程就绪
      barriers.providerbarrier.await(); // 等待所有生产者线程执行完成

      barriers.consumerbarrier.await(); // 等待所有消费者线程就绪
      barriers.consumerbarrier.await(); // 等待所有消费者线程执行完成
      if (barriers.takeSum.get() != barriers.putSum.get()) {
        System.out.println(barriers.takeSum.get());
        System.out.println(barriers.putSum.get());
//        System.out.println(reduce);
      }

    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }


  }

  static class Provider implements Runnable {

    barriers barriers;

    public Provider(barriers barriers) {
      this.barriers = barriers;
    }

    @Override
    public void run() {
      // 保证当前seed的不重复
      int seed = xorShift();
      int sum = 0;
      try {
        barriers.providerbarrier.await();

        for (int i =  barriers.nTrials; i > 0; --i) {
          barriers.bb.put(seed);
          sum += seed;
          seed = xorShift();
        }
        barriers.putSum.getAndAdd(sum);
        barriers.providerbarrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  static class Consumer implements Runnable {

    barriers barriers;

    public Consumer(barriers barriers) {
      this.barriers = barriers;
    }

    @Override
    public void run() {
      int sum = 0;
      try {
        barriers.consumerbarrier.await();
        // nTrials 安全发布。
        for (int i = barriers.nTrials; i > 0; --i) {

          int take = barriers.bb.take();
          sum += take;
        }
        barriers.takeSum.getAndAdd(sum);
        barriers.consumerbarrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      new barriers(10, 200, 11).test(new barriers(10, 200, 11));
    }

    // 为啥线程池无法停止执行， 待确定
//     pool.awaitTermination(1000L, TimeUnit.MILLISECONDS);
    pool.shutdown();
  }

}
