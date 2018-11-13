package Concurrent.CountDownLatch;

import static Concurrent.ConcurrentExecutorHarness.executorService;
import static Concurrent.commoned.commonDemoExecutor.awaitTerminations;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import lombok.Getter;
import lombok.Setter;

/**
 * 闭锁  CountDownLatch -> 同步工具,  保持多个线程同时到达临界点 Created by hcj on 18-4-6
 */
@Setter
@Getter
public class CountDownLatchExecutorDemo {

  private Integer count = 0;
  private List<Thread> lists = new LinkedList<>();
  // 开始边界范围
  private static CountDownLatch countDownLatch = new CountDownLatch(1);
  // 结束边界
  private static CountDownLatch countDownLatchEnd = new CountDownLatch(10);

  public int getCount() {

    return count;
  }

  public void setCount(int count) {
//    System.out.println("Set count :" + count);
    this.count = count;
  }

  public static void main(String[] args) throws InterruptedException {

    CountDownLatchExecutorDemo commonDemo = new CountDownLatchExecutorDemo();
      countDownLatchMain(commonDemo);


  }

  public static void countDownLatchMain(CountDownLatchExecutorDemo commonDemo)
      {
//    System.out.println(Thread.currentThread().getName());

    commonDemo.threadStart();
      // 计算时间
      countDownLatch.countDown();
      // 等待所有线程执行完毕
        try {
          countDownLatchEnd.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        // 等待线程死亡
        awaitTerminations();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("result :" + commonDemo.getCount());
        // 清 0
        commonDemo.setCount(0);
  }

  public void threadStart() {
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          try {
//            System.out.println(Thread.currentThread().getName());
            try {
              countDownLatch.await();



            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            plusOper(finalI);
          } finally {
            countDownLatchEnd.countDown();
          }
        }
      });
    }

  }

  public  void plusOper(int finalI) {

//      System.out.println("input: " + finalI);
      count += finalI;
  }
}
