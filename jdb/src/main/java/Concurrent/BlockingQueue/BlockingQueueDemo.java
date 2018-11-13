package Concurrent.BlockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.Getter;
import lombok.Setter;

/**
 * 阻塞队列, 生产者和消费者模式 logService
 * 生产日志,并另开线程输出到..
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class BlockingQueueDemo {

  private final  static BlockingQueue<String> queue = new LinkedBlockingQueue(2);
  private LoggerThread loggerThread =new LoggerThread();

  public void start(){loggerThread.start();}
  public void log(String msg)  {
    try {
      queue.put(msg);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  private class LoggerThread extends Thread{
    private  PrintWriter printWriter;

    public LoggerThread()  {
      try {
        this.printWriter = new PrintWriter(new File("/home/hcj/IdeaProjects/jdb/output.log"));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void run() {
      // 日志记录
      try {
        while (true){
          String msg = queue.take();
          printWriter.write(msg);
          printWriter.flush();
        }
      } catch (InterruptedException e) {
        // 传递中断信息
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }finally {
        printWriter.close();
      }
    }
  }
    public   static  void main(String[] args){
      //
      ExecutorService executorService = Executors.newCachedThreadPool();
      //  newFixedThreadPool  若corePoolSize < maxPoolSize ，那么当任务数大于corePoolSize时，应该是
      // 会继续继续上涨到最大值，？ 还是先存入到队列中 ？。 待测试。怎么测
      ExecutorService executorService1 = Executors.newFixedThreadPool(10);
      ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService1;
      threadPoolExecutor.setMaximumPoolSize(100);
//      new CyclicBarrier(10,);
      BlockingQueueDemo blockingQueueDemo = new BlockingQueueDemo();
      blockingQueueDemo.log("哈哈");
//      ArrayBlockingQueue
//          LinkedBlockingQueue
//      LinkedBlockingDeque

      blockingQueueDemo.start();

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      BlockingQueueDemo blockingQueueDemo1 = new BlockingQueueDemo();
      blockingQueueDemo1.log("哈哈1");
      blockingQueueDemo1.start();

      // 中断操作



    }
}
