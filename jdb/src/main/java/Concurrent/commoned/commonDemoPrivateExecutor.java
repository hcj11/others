package Concurrent.commoned;

import static Concurrent.ConcurrentExecutorHarness.executorService;

import Concurrent.commonExecutorService.countExecutorService;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;

/**
 *  Executor线程池
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class commonDemoPrivateExecutor {

  private Integer count = 0;
  private List<Thread> lists = new LinkedList<>();

  public static void main(String[] args) {
      commonDemoPrivateExecutor commonDemo = new commonDemoPrivateExecutor();
      commonMain(commonDemo);

  }
  public static void commonMain(commonDemoPrivateExecutor commonDemo) {
   countExecutorService countExecutorService =new  countExecutorService();
    // 计算时间
    commonDemo.threadStart(countExecutorService);
    countExecutorService.stop();
//    System.out.println("Result: " + commonDemo.getCount());
    commonDemo.setCount(0);
  }


  public void threadStart(countExecutorService countExecutorService) {

    for (int i = 1; i <= 10; i++) {
      int finalI = i;
        countExecutorService.count(new Runnable() {
        @Override
        public void run() {
          System.out.println(finalI);
          count += finalI;
        }
      });
    }
  }


}
