package Concurrent.question2.finishCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hcj on 18-5-27 栅栏 + + List 做容器
 */
public class phasers {


  /**
   * 栅栏 Created by hcj on 18-5-27
   */

//  private final static ExecutorService pool = Executors.newCachedThreadPool();

  // takeSum
  private final AtomicInteger takeSum = new AtomicInteger(0);
  // putSum
  private final AtomicInteger putSum = new AtomicInteger(0);
  private final ConcurrentLinkedQueue<ConcurrentLinkedQueue> bb;

  private final ConcurrentLinkedQueue<Integer> bbs;
  // pharse相位器 provider

  // pharse相位器 consumer
  // pharse相位器 put
  private int nPairs, nTrials;

//  public phasers() {
//
//  }

  static int xorShift() {
    // [0,1) -> [0,9] -> [1,10)
    int y = 10;
    return (int) (Math.random() * y) + 1;

  }

  public phasers(int nPairs, int nTrials, int MaxSize) {
    bb = new ConcurrentLinkedQueue<>(); // 10,200,11
    bbs = new ConcurrentLinkedQueue<>();
    this.nPairs = nPairs; // 5 个 provider and 5 个 consumer
    this.nTrials = nTrials; // 200   => 5 * 200=1000个整数

  }

  void test(phasers phasers) {
    List<Phaser> lists = new ArrayList<>();
    // 【100次产生数据】  只要10次循环
    final Phaser phaserconsumerStart = new Phaser(1); //5+1 =6
    final Phaser phaserconsumerEnd = new Phaser() {
      @Override
      protected boolean onAdvance(int phase, int registeredParties) {
//        System.out.println("phaserconsumerStart====== " + phase + " ======"); // 0,5
        return phase >= 0 || registeredParties == 0;
      }
    };

    final Phaser phaserproviderEnd = new Phaser() {
      @Override
      protected boolean onAdvance(int phase, int registeredParties) {
//        System.out.println("phaserproviderEnd====== " + phase + " ======"); // 0,5
        return phase >= 0 || registeredParties == 0;
      }
    };

    // 构建任务
    LinkedList<Provider> objects = new LinkedList<>();
    // 5
    for (int i = 0; i < (int) phasers.nPairs / 2; i++) {

      ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
      Provider provider = new Provider(concurrentLinkedQueue, phasers);
      objects.add(provider);
      phasers.bb.add(concurrentLinkedQueue);
    }

    Consumer consumer = new Consumer(phasers);

    phaserproviderEnd.register();
    phaserconsumerEnd.register();
    // 10
    for (int i = 1; i <= phasers.nPairs; i++) {

      if (i % 2 != 0) {
        Provider pop = objects.pop();
        phaserproviderEnd.register();
        new Thread(new Runnable() {
          @Override
          public void run() {
            do {
              pop.run();
              phaserproviderEnd.arriveAndAwaitAdvance();
            } while (!phaserproviderEnd.isTerminated());

          }
        }).start();
      } else {
        phaserconsumerStart.register();
        phaserconsumerEnd.register();
        new Thread(new Runnable() {
          @Override
          public void run() {
            phaserconsumerStart.arriveAndAwaitAdvance();
//            System.out.println("phase: "+phaserconsumerStart.getPhase());
            do {
              consumer.run();
              phaserconsumerEnd.arriveAndAwaitAdvance();
            } while (!phaserconsumerEnd.isTerminated());

          }
        }).start();
      }
    }

    phaserproviderEnd.arriveAndDeregister();

    phaserproviderEnd.register();
    while (!phaserproviderEnd.isTerminated()) {
      phaserproviderEnd.arriveAndAwaitAdvance();
    }
//    System.out.println(bb.size());
//    System.out.println(Arrays.toString(bb.toArray()));
    for (ConcurrentLinkedQueue list : phasers.bb) {
      phasers.bbs.addAll(list);
    }

    // 开始消费
    phaserconsumerStart.arriveAndDeregister();
    // 消费结束
    phaserconsumerEnd.arriveAndDeregister();

    // 等待消费者 消费所有的产品
    phaserconsumerEnd.register();
    while (!phaserconsumerEnd.isTerminated()) {
      phaserconsumerEnd.arriveAndAwaitAdvance();
    }

//    Integer reduce = bbs.stream().reduce(0, (x, y) -> x + y);
//      System.out.println(reduce);

//    System.out.println(bbs.size());
    // 消费者 消费产品

    if (phasers.takeSum.get() != phasers.putSum.get()) {
      System.out.println(phasers.takeSum.get());
      System.out.println(phasers.putSum.get());
//      System.out.println(reduce);
    }

    // 由于使用的是同一个对象  清0,清null
    phasers.putSum.set(0);
    phasers.takeSum.set(0);
    phasers.bb.clear();
    phasers.bbs.clear();

  }


  class Provider implements Runnable {

    ConcurrentLinkedQueue concurrentLinkedQueue;
    phasers phasers;


    public Provider(ConcurrentLinkedQueue concurrentLinkedQueue, phasers phasers) {
      this.concurrentLinkedQueue = concurrentLinkedQueue;
      this.phasers = phasers;
    }


    @Override
    public void run() {
      // 保证当前seed的不重复
      int seed = xorShift();
      int sum = 0; // 200->valiate
      for (int i = 0; i < phasers.nTrials; i++) {
        concurrentLinkedQueue.offer(seed);
        sum += seed;
        seed = xorShift();
      }
      phasers.putSum.getAndAdd(sum);
    }
  }

  class Consumer implements Runnable {

    phasers phasers;

    public Consumer(phasers phasers) {
      this.phasers = phasers;
    }

    @Override
    public void run() {
      int sum = 0;
      for (int i = 0; i < phasers.nTrials; i++) {
        int take = phasers.bbs.poll();
        sum += take;
      }
      phasers.takeSum.getAndAdd(sum);
    }
  }

  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    for (int i = 0; i < 1000; i++) {

      new phasers(10, 200, 11).test(new phasers(10, 200, 11));
      // 100 * 10 =>
    }
//    pool.shutdown();
    // 为啥线程池无法停止执行， 待确定
//     pool.awaitTermination(1000L, TimeUnit.MILLISECONDS);

  }

}

