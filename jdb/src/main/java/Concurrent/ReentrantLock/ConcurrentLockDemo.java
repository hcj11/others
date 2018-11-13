package Concurrent.ReentrantLock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hcj on 18-4-6
 */
public class ConcurrentLockDemo {

  /**
   * 待完善, Created by hcj on 18-4-6.
   */
  private Integer count = 0;
  private final ReentrantLock lock = new ReentrantLock();

  private static final List<Thread> lists = new LinkedList<>();

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public static void main(String[] args) {
    ConcurrentLockDemo commonDemo = new ConcurrentLockDemo();

    for (int i = 0; i < 6000; i++) {
      commonDemo.ConcurrentLockMain();
    }
  }

  public void ConcurrentLockMain() {
    threadStart();
    for (Thread thread : lists) {
      try {
        thread.join(); // timeout=0s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (count != 55) {

      System.out.println("result :" + count);
    }
    count = 0;
  }

  public void threadStart() {
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          plusOper(finalI);
        }
      });
      lists.add(thread);
      thread.start();
    }

  }

  public void plusOper(int finalI) {
    //  System.out.println(finalI);
    // 显示锁
//    int holdCount = lock.getHoldCount();
//    System.out.println(lock.getQueueLength());
//    if(holdCount>0){
//
//      System.out.println(holdCount);
//    }
      lock.lock();
      count += finalI;
      lock.unlock();




  }
}
