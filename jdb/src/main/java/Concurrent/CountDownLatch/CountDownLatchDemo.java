package Concurrent.CountDownLatch;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import lombok.Getter;
import lombok.Setter;

/**
 * 闭锁  CountDownLatch -> 同步工具,  保持多个线程同时到达临界点 Created by hcj on 18-4-6
 */
@Setter
@Getter
public class CountDownLatchDemo {

  private Integer count = 0;
  private static final List<Thread> lists = new LinkedList<>();
  // 开始边界范围
  private static final CountDownLatch countDownLatch = new CountDownLatch(1);
  // 同步边界范围
  private static final CountDownLatch countDownLatchSynchronized = new CountDownLatch(1);

  // 结束边界
  private final static CountDownLatch countDownLatchEnd = new CountDownLatch(10);

  private final static Map<Integer, CountDownLatch> list1 = Collections
      .synchronizedMap(new HashMap<>());

  private final static Map<Integer, CountDownLatch> listEnd1 = Collections
      .synchronizedMap(new HashMap<>());


  private final static Map<Integer, CountDownLatch> list = Collections
      .synchronizedMap(new HashMap<>());

  private final static Map<Integer, CountDownLatch> listEnd = Collections
      .synchronizedMap(new HashMap<>());

  private final static ArrayList<String> strs = new ArrayList<>();

//  private final static Hashtable<Integer,CountDownLatch> list =new Hashtable<Integer,CountDownLatch>();
//  private final static Hashtable<Integer,CountDownLatch> listEnd = new Hashtable<Integer,CountDownLatch>();

//  private final static ConcurrentHashMap list = new ConcurrentHashMap();
//
//  private final static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

  //  List<CountDownLatch> list =new LinkedList();
//
//  List<CountDownLatch> listEnd = new LinkedList();

//  static {
//
//
//  }


  public int getCount() {

    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public static void main(String[] args) throws InterruptedException {
//    LinkedList<Integer> objects = new LinkedList<>();
//    objects.add(1);
//    objects.add(2);
//    objects.add(3);
//    System.out.println(objects.offer());
//    System.out.println(objects.peek());
//    System.out.println(objects.peek());
//    Thread.sleep(1000);
    CountDownLatchDemo commonDemo = new CountDownLatchDemo();
    for (int i = 0; i < 2000; i++) {
      countDownLatchMain(commonDemo);
    }

  }

  public static void countDownLatchMain(CountDownLatchDemo commonDemo) {
    listEnd.clear();
    list.clear();
    for (int j = 1; j <= 10; j++) {
      list.put(j, new CountDownLatch(1)); // 1-10
      listEnd.put(j, new CountDownLatch(1));
    }

    commonDemo.threadStart();
    // 计算时间
    int count = 0;
    int substr = 0;
    Set<Entry<Integer, CountDownLatch>> entries = list.entrySet();
    Set<Entry<Integer, CountDownLatch>> entriesEnd = listEnd.entrySet();

    for (Entry<Integer, CountDownLatch> entry : entries) {
      Integer key = entry.getKey();

      while (true) {
        for (Thread thread : lists) {
          if (thread.getState().equals(State.WAITING)) {
            ++count;
          }
        }
        if (count == 10 - substr) {
          substr++;
          entry.getValue().countDown();
          count = 0;
          break;
        } else {
          count = 0;
        }
      }

      for (Entry<Integer, CountDownLatch> entryEnd : entriesEnd) {
        Integer key1 = entryEnd.getKey();
        CountDownLatch value = entryEnd.getValue();

        if (key.equals(key1)) {
          try {
            value.await();

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }

    // 等待线程死亡
    for (Thread thread : lists) {
      try {
        thread.join(); // timeout=0s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (commonDemo.getCount() != 55) {
      System.out.println("result :" + commonDemo.getCount());
    }
    commonDemo.setCount(0);
  }

  public void threadStart() {
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
//      int finalI = i - 1;
      int finalI2 = i;
      // 创建10个闭锁

      Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {

            try {
              plusOper(finalI2);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

        }
      });
      thread.start();

      lists.add(thread);
    }

  }

  public void plusOper(int finalI) throws InterruptedException {
//    System.out.println(finalI);
    // 闭锁，保证同时只有只有一个线程可以开始执行,等待已经执行完成该方法的线程countDown
    // 若一个线程完成一个闭锁任务，就新建一个新的任务给其他的线程，以期望谁先抢到该闭锁即可呀，
    // 需要确定某个线程对应的编号，那么这个闭锁就只对该编号开放countDown操作的话
    // 就可以实现同步了, 那么
    // 记录当前的线程编号

    // 必须保证全部线程全部在等待
//    System.out.println("入 " + finalI);
    CountDownLatch pop = list.get(finalI);
    // 确定多个线程在此阻塞
    pop.await();

    count += finalI;

//    System.out.println("出 " + finalI);
    listEnd.get(finalI).countDown();

  }
}
