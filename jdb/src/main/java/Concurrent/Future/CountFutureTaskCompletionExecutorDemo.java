package Concurrent.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;

/**
 * FutureTask  提前加载稍后需要的数据, CompletionExecutor 异构任务并行化 Created by hcj on 18-4-6
 * blockingqueue + executor
 */
@Setter
@Getter
public class CountFutureTaskCompletionExecutorDemo {

  private Integer count = 0;
  private ExecutorService executorService = Executors.newCachedThreadPool();
  private java.util.concurrent.CompletionService<Integer> completionService = new ExecutorCompletionService<>(
      executorService);

  public int getCount() {

    return count;
  }

  public void setCount(int count) {
//    System.out.println("Set count :" + count);

    this.count = count;
  }

  public static void main(String[] args)
      throws InterruptedException, IllegalAccessException, InstantiationException {
//    CountFutureTaskCompletionExecutorDemo commonDemo = new CountFutureTaskCompletionExecutorDemo();
    CountFutureTaskCompletionExecutorDemo commonDemo = CountFutureTaskCompletionExecutorDemo.class
        .newInstance();
    for (int i = 0; i < 2000; i++) {
      ConcurrentFutureMain(commonDemo);
    }

    commonDemo.executorService.shutdown();
    commonDemo.executorService.awaitTermination(10, TimeUnit.HOURS);

  }

  public static void ConcurrentFutureMain(CountFutureTaskCompletionExecutorDemo commonDemo) {
    int sum = 0;
    commonDemo.threadStart();

    CompletionService<Integer> completionService = commonDemo.getCompletionService();
    // 获取数据
    try {
      for (int i = 0; i < 10; i++) {

        Future<Integer> take = completionService.take();
        try {
          Integer integer = take.get();
//          System.out.println(integer);
          sum += integer;
        } catch (ExecutionException e) {
          e.printStackTrace();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (sum != 55) {

      System.out.println("result :" + sum);
    }

  }

  public void threadStart() {
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      completionService.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          return finalI;
        }
      });
    }

  }
}
