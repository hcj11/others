package possibleRecordering;

import java.util.concurrent.atomic.AtomicReference;

public class UnreentrantLock {

  private final static AtomicReference<Thread> owner = new AtomicReference<Thread>();

//  public void lock() {
//    Thread current = Thread.currentThread();
//    //这句是很经典的“自旋”语法，AtomicInteger中也有
//    for (; ; ) {
//      if (!owner.compareAndSet(null, current)) {
//        return;
//      }
//    }
//  }
//
//  public void unlock() {
//    Thread current = Thread.currentThread();
//    owner.compareAndSet(current, null);
//  }

  public static void main(String[] args) {
//    UnreentrantLock unreentrantLock = new UnreentrantLock();
    Thread thread = Thread.currentThread();
    String name = thread.getName();
    System.out.println("初始值: "+name);
    thread.setName("哈哈哈");
//    UnreentrantLock.owner.compareAndSet("d");
//    Thread thread1 = UnreentrantLock.owner.get();
//    System.out.println(thread1.getName());
//
//    UnreentrantLock.owner.set(thread);
//    Thread thread1 = UnreentrantLock.owner.get();
//    System.out.println(thread1.getName());

//    Thread thread = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        UnreentrantLock unreentrantLock = new UnreentrantLock();
//        unreentrantLock.lock();
//        UnreentrantLock unreentrantLock1 = new UnreentrantLock();
//        unreentrantLock1.lock();
//      }
//    });
//
//    thread.start();


  }
}