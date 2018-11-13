package Concurrent.Semaphore;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import lombok.Getter;
import lombok.Setter;

/**
 * Semaphore  用来控制同时访问某个特定资源的操作数量,  场景: 对容器添加边界
 *
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class CountSemaphoreDemo {

  private Integer count = 0;
  private final List<Thread> lists = new LinkedList<>();
  private final List<Integer> ids = new LinkedList<>();
  private final List<Integer> idAdds = new LinkedList<>();
  // 信号量太多了? 比如10个, 导致有的线程join一直等待?, 改成1个信号量的话,或许会好一点?
  private final Semaphore sem = new Semaphore(1); // 信号量


  public int getCount() {

    return count;
  }

  public void setCount(int count) {
//    System.out.println("Set count :" + count);
    this.count = count;
  }

  public static void main(String[] args) throws InterruptedException {
    CountSemaphoreDemo commonDemo = new CountSemaphoreDemo();
    for (int i=0;i<2000;i++){

      SemaphoreMain(commonDemo);
    }

  }

  public static void SemaphoreMain(CountSemaphoreDemo commonDemo) {

//    long startMills = Instant.now().toEpochMilli();
    commonDemo.threadStart();
    // 计算时间
    for (Thread thread : commonDemo.getLists()) {
      try {
        thread.join(); // timeout=0s  ,即永远等待线程的响应,要考虑线程中断了
//        System.out.println("join 等待,");
      } catch (InterruptedException e) {
        // 容易死锁?,还是?,  40min 未結束
        e.printStackTrace();
      }
    }
    if(commonDemo.getCount()!=55){

      System.out.println("result :" + commonDemo.getCount());
    }
//    long endMills = Instant.now().toEpochMilli();
//    System.out.println("耗时 / ms :" + String.valueOf(endMills - startMills));
    // 清 0
    commonDemo.setCount(0);
  }

  // 获取信号量
  private Boolean add(Integer id) throws InterruptedException {
    sem.acquire(); // 可能会有阻塞, 和 sem.release();  的不对称
    boolean wasAdd = false;
    try {
      wasAdd = ids.add(id);
      return wasAdd;
    } finally {
      if (!wasAdd) {
        sem.release();
      }
    }
  }

  private Boolean remove(Integer id) {
    boolean remove = ids.remove(id);
    if (remove) {
      sem.release();
    }
    return remove;
  }

  public void threadStart() {
    //  先清空多余的线程
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            add(finalI);
//            System.out.println("并发调用到: " + finalI);
            plusOper(finalI);

            remove(finalI);// 释放该元素
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
      thread.start();
      lists.add(thread);
    }

  }

  // 方法范围的锁 synchronized
  public void plusOper(int finalI) {
//    System.out.println(finalI);
//    int count = getCount();
    count += finalI;
//    setCount(count);
  }
}
