package Concurrent.Deadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by hcj on 18-8-4
 */
public class ExutorsDeadLock {

  private final ExecutorService service = Executors.newFixedThreadPool(11);
  private final ExecutorService service2 = Executors.newSingleThreadExecutor();


  public static void main(String[] args) {
    ExutorsDeadLock exutorsDeadLock = new ExutorsDeadLock();
   exutorsDeadLock.startUp();
  }

  private void startUp() {
    TaskFucture  taskFucture = new TaskFucture();
    Future<String> submit = service.submit(taskFucture);
    try {
      // 发送死锁，
      System.out.println(submit.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  class TaskFucture implements Callable<String> {

    // 加载数据
    @Override
    public String call() throws Exception {
      Future<String> submit1, submit2;
      submit1 = service.submit(new Callable<String>() {
        @Override
        public String call() throws Exception {
          return "one ,task over";
        }
      });

      submit2 = service.submit(new Callable<String>() {

        @Override
        public String call() throws Exception {
          return "two ,task over";
        }
      });

      return submit1.get()+"  , interval , "+ submit2.get();
    }
  }


}
