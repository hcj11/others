package Concurrent.Future;

import static Concurrent.ConcurrentExecutorHarness.executorService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import lombok.Getter;
import lombok.Setter;

/**
 * FutureTask  提前加载稍后需要的数据,
 * futureTask.get() 进行阻塞, 可以获取所有线程的数据
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class CountFutureTaskExecutorDemo {

  private Integer count = 0;
  private List<FutureTask> futureTasklists = new LinkedList<>();

  public int getCount() {

    return count;
  }

  public void setCount(int count) {
//    System.out.println("Set count :" + count);
    this.count = count;
  }

  public static void main(String[] args) throws InterruptedException {
    CountFutureTaskExecutorDemo commonDemo = new CountFutureTaskExecutorDemo();

    ConcurrentFutureMain(commonDemo);

  }

  public static void ConcurrentFutureMain(CountFutureTaskExecutorDemo commonDemo)
      {
    int sum=0;
    commonDemo.threadStart();

    for (FutureTask futureTask : commonDemo.getFutureTasklists()) {
      try {

        Integer integer = Integer.valueOf(String.valueOf(futureTask.get()));
//        System.out.println("future: "+integer);
        sum+=integer;
      } catch (ExecutionException | InterruptedException e) {
        e.printStackTrace();
      }
    }
     // 清空任务集
      commonDemo.getFutureTasklists().clear();

      System.out.println("result :" + sum);
  }

  public void threadStart() {
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      FutureTask futureTask = new FutureTask<>(new Callable<Object>() {
        @Override
        public Object call() throws Exception {
          return finalI;
        }
      });

      executorService.submit(futureTask);
      futureTasklists.add(futureTask);
    }

  }
}
