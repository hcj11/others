package Concurrent.Future;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import lombok.Getter;
import lombok.Setter;

/**
 * FutureTask  提前加载稍后需要的数据, futureTask.get() 进行阻塞, 可以获取所有线程的数据 Created by hcj on 18-4-6
 */
@Setter
@Getter
public class CountFutureTaskDemo {

  private Integer count = 0;
  private List<Thread> lists = new LinkedList<>();
  private List<FutureTask> futureTasklists = new LinkedList<>();

  public int getCount() {

    return count;
  }

  public void setCount(int count) {
//    System.out.println("Set count :" + count);
    this.count = count;
  }

  public static void main(String[] args) throws InterruptedException {
    CountFutureTaskDemo commonDemo = new CountFutureTaskDemo();

    ConcurrentFutureMain(commonDemo);

  }

  public static void ConcurrentFutureMain(CountFutureTaskDemo commonDemo) {
    int sum = 0;
    commonDemo.threadStart();
    // 计算时间
//    long startMills = Instant.now().toEpochMilli();
    // 开始启动线程
//    commonDemo.startup(commonDemo);
    for (Thread thread : commonDemo.getLists()) {
      try {
        thread.join(); // timeout=0s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // 等待线程结果
    for (FutureTask futureTask : commonDemo.getFutureTasklists()) {
      try {

        Integer integer = Integer.valueOf(String.valueOf(futureTask.get()));
//        System.out.println("future: "+integer);
        sum += integer;
      } catch (ExecutionException | InterruptedException e) {
        e.printStackTrace();
      }
    }
    // 清空任务集
    commonDemo.getFutureTasklists().clear();

    if (sum != 55) {

      System.out.println("result :" + sum);
    }
//    long endMills = Instant.now().toEpochMilli();
//    System.out.println("耗时 / ms :"+String.valueOf(endMills-startMills));
    // 清 0
  }

  public void threadStart() {
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      FutureTask futureTask = new FutureTask<>(new Callable<Object>() {
        @Override
        public Object call() throws Exception {
          return finalI;
        }
      });

      Thread thread = new Thread(futureTask);
      thread.start();
      lists.add(thread);
      futureTasklists.add(futureTask);
    }

  }

  private void startup(CountFutureTaskDemo commonDemo) {
    // 当循环创建线程时,就会出现  IllegalThreadStateException ,使用到原线程的问题
    for (Thread thread : commonDemo.getLists()) {
      thread.start();
    }
  }
//  public void plusOper(int finalI) {
//
//    System.out.println("input: " + finalI);
//    count += finalI;
//  }
}
