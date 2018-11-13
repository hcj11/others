package Concurrent.question2.finishCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * exchanger 做交换 Created by hcj on 18-5-28
 */
public class exchangers {

  private final static ExecutorService pool = Executors.newCachedThreadPool();

  // takeSum
  private final AtomicInteger takeSum = new AtomicInteger(0);
  // putSum
  private final AtomicInteger putSum = new AtomicInteger(0);
  private final ConcurrentLinkedQueue<ConcurrentLinkedQueue<Integer>> bb;
  private final ConcurrentLinkedQueue<Integer> bbs;
  private ConcurrentLinkedQueue providerSum; //
  private ConcurrentLinkedQueue consumerSum; //
  //  // 栅栏 provider
//  private final Exchanger<Integer> providerExchanger;
//  // 栅栏 consumer
//  private final Exchanger<Integer> consumerExchanger;
  private int nPairs, nTrials;

  static int xorShift() {
    // [0,1) -> [0,9] -> [1,10)
    int y = 10;
    return (int) (Math.random() * y) + 1;

  }

  public exchangers(int nPairs, int nTrials, int MaxSize) {
    bb = new ConcurrentLinkedQueue<>(); // 10,200,11
    bbs = new ConcurrentLinkedQueue<>();
    providerSum = new ConcurrentLinkedQueue<>();
    consumerSum = new ConcurrentLinkedQueue<>();
    this.nPairs = nPairs; // 5 个 provider and 5 个 consumer
    this.nTrials = nTrials; // 200   => 5 * 200=1000个整数
  }

  void test(exchangers exchangers) {
    ArrayList<Exchanger<Integer>> providerExchangerList = new ArrayList<>();
    ArrayList<Exchanger<Integer>> consumerExchangerList = new ArrayList<>();
    ArrayList<Exchanger<Integer>> consumerExchangerEndList = new ArrayList<>();

    // 构建任务
    LinkedList<Provider> objects = new LinkedList<>();
    // 5
    for (int i = 0; i < (int) exchangers.nPairs / 2; i++) {
      Exchanger<Integer> providerExchanger = new Exchanger<>();
      ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();
      Provider provider = new Provider(providerExchanger, null, concurrentLinkedQueue,exchangers);
      objects.add(provider);
      exchangers.bb.add(concurrentLinkedQueue);
      providerExchangerList.add(providerExchanger);
    }

    // 消费者等待生产者 的产品， 算是队列了?,怎么让消费者在等待， 又不能用。。 产不出来就等着，知道所有都产出
    for (int i = 1; i <= exchangers.nPairs; i++) {
      if (i % 2 != 0) {
        Provider pop = objects.pop();
        pool.execute(pop);
      } else {
        Exchanger<Integer> consumerExchanger = new Exchanger<>();
        consumerExchangerList.add(consumerExchanger);

        Exchanger<Integer> consumerExchangerEnd = new Exchanger<>();
        consumerExchangerEndList.add(consumerExchangerEnd);

        pool.execute(new Consumer(consumerExchanger, 1, consumerExchangerEnd, 2,exchangers));
      }
    }

    try {

      for (Exchanger<Integer> providerExchanger : providerExchangerList) {
        providerExchanger.exchange(1);
      }

      while (true) {
        if (exchangers.providerSum.size() == 5) {
          break;
        }
      }

      // 生产者开始 开放通道 ,并发 or 顺序

      for (ConcurrentLinkedQueue<Integer> list : exchangers.bb) {
        exchangers.bbs.addAll(list);
      }

//      Integer reduce = bbs.stream().reduce(0, (x, y) -> x + y);

      // 消费 exchange内容 ,同时传递10个 1
      // 消费者开始 开放通道 ,并发 or 顺序
      for (Exchanger<Integer> consumerExchanger : consumerExchangerList) {
        consumerExchanger.exchange(1);
      }

      // 同时结束
      for (Exchanger<Integer> consumerExchanger : consumerExchangerEndList) {
        consumerExchanger.exchange(1);
      }
      while (true) {
        if (exchangers.consumerSum.size() == 5) {
          break;
        }
      }

      if (exchangers.takeSum.get() != exchangers.putSum.get()) {
        System.out.println(exchangers.takeSum.get());
        System.out.println(exchangers.putSum.get());
//        System.out.println(reduce);
      }

      // 清空 ，清0
      exchangers.bb.clear();
      exchangers.bbs.clear();
      exchangers.consumerSum.clear();
      exchangers.providerSum.clear();
      exchangers.putSum.set(0);
      exchangers.takeSum.set(0);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

  class Provider implements Runnable {

    Exchanger<Integer> providerExchanger;
    exchangers exchangers;
    Integer a;
    ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;

    // 泛型
    public Provider(Exchanger<Integer> providerExchanger, Integer a,
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue,
        exchangers exchangers) {
      this.exchangers=exchangers;
      this.providerExchanger = providerExchanger;
      this.a = a;
      this.concurrentLinkedQueue = concurrentLinkedQueue;
    }


    @Override
    public void run() {
      // 等待传入参数

      // 保证当前seed的不重复
      int seed = xorShift();
      int sum = 0; // 200->valiate
      for (int i = 0; i < exchangers.nTrials; i++) {
        concurrentLinkedQueue.offer(seed);
        sum += seed;
        seed = xorShift();
      }
      exchangers.putSum.getAndAdd(sum);

      // 等待结束参数
      try {
        Integer exchange = providerExchanger.exchange(a);
        exchangers.providerSum.add(exchange);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  class Consumer implements Runnable {

    Exchanger<Integer> consumerexchanger;
    Exchanger<Integer> consumerexchangerEnd;
    Integer a;
    Integer b;
    exchangers exchangers;

    // 泛型
    public Consumer(Exchanger<Integer> consumerprovider, Integer a,
        Exchanger<Integer> consumerexchangerEnd, Integer b,exchangers exchangers) {
      this.consumerexchanger = consumerprovider;
      this.consumerexchangerEnd = consumerexchangerEnd;
      this.a = a;
      this.b = b;
      this.exchangers=exchangers;
    }

    @Override
    public void run() {
      int sum = 0;
      // 等待传值
      try {
        consumerexchanger.exchange(a);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      // nTrials 安全发布。
      for (int i = 0; i < exchangers.nTrials; i++) {
        int take = exchangers.bbs.poll();
        sum += take;
      }
      exchangers.takeSum.getAndAdd(sum);
      // 等待生产者传递数据到消费者， 并进行判断即可
      try {
        Integer exchange = consumerexchangerEnd.exchange(b);
        exchangers.consumerSum.add(exchange);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    for (int i = 0; i < 1000; i++) {
      new exchangers(10, 200, 11).test(new exchangers(10, 200, 11));
    }

    pool.shutdown();
    // 为啥线程池无法停止执行， 待确定
//     pool.awaitTermination(1000L, TimeUnit.MILLISECONDS);

  }

}

