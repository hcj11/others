package Concurrent.question2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hcj on 18-5-27 栅栏 + + List 做容器
 */
public class barriersList {


  /**
   * 栅栏 Created by hcj on 18-5-27
   */

  private final static ExecutorService pool = Executors.newCachedThreadPool();


  // takeSum
  private final AtomicInteger takeSum = new AtomicInteger(0);
  // putSum
  private final AtomicInteger putSum = new AtomicInteger(0);
  private final ConcurrentLinkedQueue<ConcurrentLinkedQueue> bb;

  private final ConcurrentLinkedQueue<Integer> bbs;
  // 栅栏 provider
  private final CyclicBarrier providerbarrier;
  // 栅栏 consumer
  private final CyclicBarrier consumerbarrier;
  // 栅栏 put
//  private final CyclicBarrier putbarrier;
  private int nPairs, nTrials;

  static int xorShift() {
    // [0,1) -> [0,9] -> [1,10)
    int y = 10;
    return (int) (Math.random() * y) + 1;

  }

  public barriersList(int nPairs, int nTrials, int MaxSize) {
    bb = new ConcurrentLinkedQueue<>(); // 10,200,11
    bbs = new ConcurrentLinkedQueue<>();
    this.nPairs = nPairs; // 5 个 provider and 5 个 consumer
    this.nTrials = nTrials; // 200   => 5 * 200=1000个整数
    this.providerbarrier = new CyclicBarrier(nPairs / 2 + 1); // 6
    this.consumerbarrier = new CyclicBarrier(nPairs / 2 + 1); // 6
//    this.putbarrier = new CyclicBarrier(nPairs / 2 + 1); // 6

  }

  void test() {
    for (int i = 1; i <= nPairs; i++) {
      if (i % 2 != 0) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        pool.execute(new Provider(concurrentLinkedQueue));
        bb.add(concurrentLinkedQueue);
      } else {
        pool.execute(new Consumer());
      }
    }

    try {
      providerbarrier.await(); // 等待所有生产者线程就绪
      providerbarrier.await(); // 等待所有生产者线程执行完成
      // 所有生产者统一执行完成装填操作

      for (ConcurrentLinkedQueue list : bb) {
        bbs.addAll(list);
      }
      Integer reduce = bbs.stream().reduce(0, (x, y) -> x + y);
//      System.out.println(reduce);

//      System.out.println(bbs.size());
      // 消费者 消费产品

      consumerbarrier.await(); // 等待所有消费者线程就绪
      consumerbarrier.await(); // 等待所有消费者线程执行完成

      if (takeSum.get() != putSum.get() && putSum.get() != reduce) {
        System.out.println(takeSum.get());
        System.out.println(putSum.get());
        System.out.println(reduce);
      }

    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }


  }

  class Provider implements Runnable {

    ConcurrentLinkedQueue concurrentLinkedQueue;

    public Provider(ConcurrentLinkedQueue concurrentLinkedQueue) {
      this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    @Override
    public void run() {
      // 保证当前seed的不重复
      int seed = xorShift();
      int sum = 0;
      try {
        providerbarrier.await();

        for (int i = nTrials; i > 0; --i) {
          concurrentLinkedQueue.offer(seed);
          sum += seed;
          seed = xorShift();
        }
        putSum.getAndAdd(sum);
        providerbarrier.await();
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
        consumerbarrier.await();
        for (int i = nTrials; i > 0; --i) {

          int take = bbs.poll();
          sum += take; // 线程方法栈中的数据 ,不会和其他线程出现冲突
        }
        takeSum.getAndAdd(sum);
        consumerbarrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    for (int i = 0; i < 2000; i++) {

      new barriersList(10, 200, 11).test();
    }

    // 为啥线程池无法停止执行， 待确定
//     pool.awaitTermination(1000L, TimeUnit.MILLISECONDS);
    pool.shutdown();
  }

}

