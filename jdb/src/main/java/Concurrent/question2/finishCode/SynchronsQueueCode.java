package Concurrent.question2.finishCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 同步移交队列 Created by hcj on 18-6-5
 */
public class SynchronsQueueCode {
  // synchronsQueue vs Exchanger
  /**
   * synchronsQueue Exchanger 资源重复利用，减少gc的回收
   */
  private final static ExecutorService pool = Executors.newCachedThreadPool();

  // takeSum
  private final AtomicInteger takeSum = new AtomicInteger(0);
  // putSum
  private final AtomicInteger putSum = new AtomicInteger(0);
  private final ConcurrentLinkedQueue<ConcurrentLinkedQueue<Integer>> bb;
  private final ConcurrentLinkedQueue<Integer> bbs;
  private ConcurrentLinkedQueue providerSum; //
  private ConcurrentLinkedQueue consumerSum; //
  private int nPairs, nTrials;

  static int xorShift() {
    // [0,1) -> [0,9] -> [1,10)
    int y = 10;
    return (int) (Math.random() * y) + 1;

  }

  public SynchronsQueueCode(int nPairs, int nTrials, int MaxSize) {
    bb = new ConcurrentLinkedQueue<>(); // 10,200,11
    bbs = new ConcurrentLinkedQueue<>();
    providerSum = new ConcurrentLinkedQueue<>();
    consumerSum = new ConcurrentLinkedQueue<>();
    this.nPairs = nPairs; // 5 个 provider and 5 个 consumer
    this.nTrials = nTrials; // 200   => 5 * 200=1000个整数
  }

  void test(SynchronsQueueCode synchronsQueueCode) {
    ArrayList<SynchronousQueue<Integer>> consumerSynchronousQueueList = new ArrayList<>();
    ArrayList<SynchronousQueue<Integer>> consumerSynchronousQueueEndList = new ArrayList<>();
    ArrayList<SynchronousQueue<Integer>> providerSynchronousQueueList = new ArrayList<>();

    LinkedList<Provider> objects = new LinkedList<>();
    for (int i = 0; i < (int) synchronsQueueCode.nPairs / 2; i++) {
      ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();
      SynchronousQueue<Integer> synchronousQueueId = new SynchronousQueue<>(false);
      Provider provider = new Provider(synchronousQueueId, concurrentLinkedQueue,synchronsQueueCode);
      objects.add(provider);
      providerSynchronousQueueList.add(synchronousQueueId);
      synchronsQueueCode.bb.add(concurrentLinkedQueue);
    }

    //
    // 消费者等待生产者 的产品， 算是队列了?,怎么让消费者在等待， 又不能用。。 产不出来就等着，知道所有都产出
    for (int i = 1; i <= synchronsQueueCode.nPairs; i++) {
      if (i % 2 != 0) {
        Provider pop = objects.pop();
        pool.execute(pop);
      } else {
        // 等待开始
        SynchronousQueue<Integer> consumerSynchronousQueue = new SynchronousQueue<>(false);
        consumerSynchronousQueueList.add(consumerSynchronousQueue);

        SynchronousQueue<Integer> consumerSynchronousQueueEnd = new SynchronousQueue<>(false);
        consumerSynchronousQueueEndList.add(consumerSynchronousQueueEnd);

        pool.execute(new Consumer(consumerSynchronousQueue, consumerSynchronousQueueEnd,synchronsQueueCode));
      }
    }

    try {

      for (SynchronousQueue<Integer> synchronousQueueExchanger : providerSynchronousQueueList) {
        synchronousQueueExchanger.put(1);
      }

      while (true) {
        if (synchronsQueueCode.providerSum.size() == 5) {
          break;
        }
      }

      // 生产者开始 开放通道 ,并发 or 顺序

      for (ConcurrentLinkedQueue<Integer> list : synchronsQueueCode.bb) {
        synchronsQueueCode.bbs.addAll(list);
      }

      // 消费 exchange内容 ,同时传递10个 1
      // 消费者开始 开放通道 ,并发 or 顺序
      for (SynchronousQueue<Integer> consumerSynchronousQueue : consumerSynchronousQueueList) {
        consumerSynchronousQueue.put(1);
      }

      // 同时结束
      for (SynchronousQueue<Integer> consumerSynchronousQueue : consumerSynchronousQueueEndList) {
        consumerSynchronousQueue.put(1);
      }

      while (true) {
        if (synchronsQueueCode.consumerSum.size() == 5) {
          break;
        }
      }

      // 消费者开始 开放通道 ,并发 or 顺序

      if (synchronsQueueCode.takeSum.get() != synchronsQueueCode.putSum.get()) {
        System.out.println(synchronsQueueCode.takeSum.get());
        System.out.println(synchronsQueueCode.putSum.get());
//        System.out.println(reduce);
      }

      // 清空 ，清0
      synchronsQueueCode.bb.clear();
      synchronsQueueCode.bbs.clear();
      synchronsQueueCode.consumerSum.clear();
      synchronsQueueCode.providerSum.clear();
      synchronsQueueCode.putSum.set(0);
      synchronsQueueCode.takeSum.set(0);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

  class Provider implements Runnable {

    ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;
    SynchronousQueue<Integer> synchronousQueueId;
    SynchronsQueueCode synchronsQueueCode;

    // 泛型
    public Provider(SynchronousQueue<Integer> synchronousQueueId,
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue,
    SynchronsQueueCode synchronsQueueCode) {
      this.synchronousQueueId = synchronousQueueId;
      this.concurrentLinkedQueue = concurrentLinkedQueue;
      this.synchronsQueueCode = synchronsQueueCode;
    }


    @Override
    public void run() {

      // 保证当前seed的不重复
      int seed = xorShift();
      int sum = 0; // 200->valiate
      for (int i = 0; i <synchronsQueueCode.nTrials; i++) {
        concurrentLinkedQueue.offer(seed);
        sum += seed;
        seed = xorShift();
      }
      synchronsQueueCode.putSum.getAndAdd(sum);

      try {
        // 等待结束的标志
        Integer take = synchronousQueueId.take();
        synchronsQueueCode.providerSum.add(take);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  class Consumer implements Runnable {

    SynchronousQueue<Integer> synchronousQueueId;
    SynchronousQueue<Integer> synchronousQueueIdEnd;
    Integer a;
    Integer b;
    SynchronsQueueCode synchronsQueueCode;

    // 泛型
    public Consumer(SynchronousQueue<Integer> synchronousQueueId,
        SynchronousQueue<Integer> synchronousQueueIdEnd
    ,SynchronsQueueCode synchronsQueueCode) {
      this.synchronousQueueId = synchronousQueueId;
      this.synchronousQueueIdEnd = synchronousQueueIdEnd;
      this.synchronsQueueCode = synchronsQueueCode;
//      this.a = a;
//      this.b = b;
    }

    @Override
    public void run() {
      int sum = 0;
      // 等待传值
      try {
        synchronousQueueId.take();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      // nTrials 安全发布。
      for (int i = 0; i < synchronsQueueCode.nTrials; i++) {
        int take = synchronsQueueCode.bbs.poll();
        sum += take;
      }
      synchronsQueueCode.takeSum.getAndAdd(sum);
      // 等待生产者传递数据到消费者， 并进行判断即可
      try {
        Integer exchange = synchronousQueueIdEnd.take();
        synchronsQueueCode.consumerSum.add(exchange);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    for (int i = 0; i < 1000; i++) {
      new SynchronsQueueCode(10, 200, 11).test(new SynchronsQueueCode(10, 200, 11));
    }


    pool.shutdown();
    // 为啥线程池无法停止执行， 待确定
//     pool.awaitTermination(1000L, TimeUnit.MILLISECONDS);

  }
}










