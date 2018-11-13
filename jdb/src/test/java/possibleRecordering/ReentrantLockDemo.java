package possibleRecordering;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hcj on 18-5-24
 */
public class ReentrantLockDemo {

  public synchronized void demo1() {
    // 可重入锁测试
    System.out.println("demo1");
  }

  public synchronized void demo2() {
    // 可重入锁测试
    System.out.println("demo2");
  }

  public synchronized void demo3() {
    // 可重入锁测试
    demo1();
    demo2();
  }

  public synchronized void reentrantLockDemo() {
    // 可重入锁测试
    ReentrantLock reentrantLock = new ReentrantLock();
    reentrantLock.lock();
    demo1();
    demo2();
    reentrantLock.unlock();
  }

  public static void main(String[] args) {
    ReentrantLockDemo reStartLock = new ReentrantLockDemo();
//    reStartLock.demo3();
    reStartLock.reentrantLockDemo();
  }
}
