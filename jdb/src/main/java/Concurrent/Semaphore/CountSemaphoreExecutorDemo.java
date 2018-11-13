package Concurrent.Semaphore;

import static Concurrent.ConcurrentExecutorHarness.executorService;
import static Concurrent.commoned.commonDemoExecutor.awaitTerminations;

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
public class CountSemaphoreExecutorDemo {

  private Integer count = 0;
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
    CountSemaphoreExecutorDemo commonDemo = new CountSemaphoreExecutorDemo();

    SemaphoreMain(commonDemo);

  }

  public static void SemaphoreMain(CountSemaphoreExecutorDemo commonDemo) {

//    long startMills = Instant.now().toEpochMilli();
    commonDemo.threadStart();
    // 计算时间
    awaitTerminations();
    System.out.println("result :" + commonDemo.getCount());
    commonDemo.setCount(0);
  }

  // 获取信号量
  private Boolean add(Integer id) throws InterruptedException {
    sem.acquire(); // 可能会有阻塞, 和         sem.release();  的不对称
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
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      executorService.submit(new Runnable() {
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
