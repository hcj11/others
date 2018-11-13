package Concurrent.Synchronized;

import static Concurrent.ConcurrentExecutorHarness.executorService;
import static Concurrent.commoned.commonDemoExecutor.awaitTerminations;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-4-6
 */
@Getter
@Setter
public class SynchronizedExecutorDemo {

  private Integer count = 0;

  public  int getCount() {

    return count;
  }
  public  void setCount(int count) {
//    System.out.println("Set count :"+count);
    this.count = count;
  }

  public static void main(String[] args) {
    SynchronizedExecutorDemo commonDemo = new SynchronizedExecutorDemo();
    SynchronizedMain(commonDemo);
  }

  public static  void SynchronizedMain(SynchronizedExecutorDemo commonDemo){
    commonDemo.threadStart();
    // 线程等待死亡

    awaitTerminations();
    System.out.println("result :"+commonDemo.getCount());
    commonDemo.setCount(0);
  }

  public  void threadStart() {
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          plusOper(finalI);
        }
      });
    }

  }

  // 方法范围的锁
  public  synchronized void plusOper(int finalI) {
//      System.out.println(finalI);
      int count = getCount();
      count+=finalI;
      setCount(count);
  }
}
