package Concurrent.Synchronized;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-4-6
 */
@Getter
@Setter
public class SynchronizedDemo {

  private Integer count = 0;
  private List<Thread> lists = new LinkedList<>();

  // synchronized
  public int getCount() {

    return count;
  }

  // synchronized
  public void setCount(int count) {
//    System.out.println("Set count :"+count);
    this.count = count;
  }

  public static void main(String[] args) {

    SynchronizedDemo commonDemo = new SynchronizedDemo();
    for(int i=0;i<20000;i++){

      SynchronizedMain(commonDemo);
    }

  }

  public static void SynchronizedMain(SynchronizedDemo commonDemo) {
    commonDemo.threadStart();
    // 线程等待死亡
    for (Thread thread : commonDemo.getLists()) {
      try {
        thread.join(); // timeout=0s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (commonDemo.getCount() != 55) {
      System.out.println("Result: " + commonDemo.getCount());
    }
//    System.out.println("result :"+commonDemo.getCount());
    commonDemo.setCount(0);
  }

  public void threadStart() {
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          plusOper(finalI);
        }
      });
      thread.start();
      lists.add(thread);
    }

  }

  // 方法范围的锁 synchronized
  public  void plusOper(int finalI) {
    synchronized(this){ // 方法该方法的对象,  或者以一个不变的对象作为锁 this.
      // this.count 是锁不住的因为他会变,
      int count = getCount();
      count += finalI;
      setCount(count);
    }
//      System.out.println(finalI);

    // 某些线程报错，会导致死锁吗
//    if (finalI % 2 == 0) {
//      int i = 1 / 0; // RuntimeException 并不会导致线程的锁不释放，而是会释放锁
//      System.out.println(i);
//    }

  }
}
