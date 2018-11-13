package Concurrent.Executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * Created by hcj on 18-4-22
 */
public class TreadDead {

  // 线程饥饿死锁
  private static final ExecutorService exec = Executors.newSingleThreadExecutor();


  // 主任务
  public static class MainTask implements Callable {


    @Override
    public Object call() throws Exception {
      Future<?> header = exec.submit(new Runnable() {
        @Override
        public void run() {
          System.out.println("获取页头");
        }
      });

      Future<?> footer = exec.submit(new Runnable() {
        @Override
        public void run() {
          System.out.println("获取页尾");
        }
      });
      return header.get() + "获取内容" + footer.get();

//      Executors.newCachedThreadPool();
    }
  }


  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 发生死锁
    Future submit = exec.submit(new MainTask());
    System.out.println(submit.get());



    ThreadFactory threadFactory = Executors.defaultThreadFactory();


  }
}
