package Concurrent.commoned;

import static Concurrent.ConcurrentExecutorHarness.executorService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;

/**
 *  Executor线程池
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class commonDemoExecutor {

  private Integer count = 0;
  private List<Thread> lists = new LinkedList<>();

  public static void main(String[] args) {
      commonDemoExecutor commonDemo = new commonDemoExecutor();
      commonMain(commonDemo);


  }
  public static void commonMain(commonDemoExecutor commonDemo) {

    // 计算时间
    commonDemo.threadStart();
    // 关闭线程池 ,等待线程结束才结束,
    // 但是没有Thread.Shutdown 的 awaitTerminations只是在等时间, 当前状态还是运行状态
    // 不利用线程池对线程的回收? 可以将线程池做成一个服务,
    awaitTerminations();
    System.out.println("Result: " + commonDemo.getCount());
    commonDemo.setCount(0);
  }

  public static void awaitTerminations() {
    try {
//      executorService.shutdown();
      // 等 100 milli ,若提供的时间不足的话,就会导致数据异常,或者进行while 判断?
      executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
//      System.out.println(executorService.isTerminated());
//      while(true){
//        if(executorService.isTerminated()){
//            break;
//        }
//    }
    System.out.println(executorService.isTerminated());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }


  public void threadStart() {

    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      executorService.submit(new Runnable() {
        @Override
        public void run() {
//          System.out.println(finalI);
          count += finalI;
        }
      });
    }
  }



}
