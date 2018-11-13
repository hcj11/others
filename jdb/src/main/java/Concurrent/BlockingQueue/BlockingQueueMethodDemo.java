package Concurrent.BlockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import lombok.Getter;
import lombok.Setter;

/**
 * 阻塞队列, 生产者和消费者模式 测试 , 不可取消的任务在退出前恢复中断, Created by hcj on 18-4-6
 */
@Setter
@Getter
public class BlockingQueueMethodDemo {

  private final static BlockingQueue<String> queue = new LinkedBlockingQueue();

  private String getNextMsg() {
    Boolean interrputed = false;
    try {
      while (true) {
        try {
            System.out.println(Thread.currentThread().isInterrupted());
            return  queue.take();
        } catch (InterruptedException e) {
          System.out.println("interrputed = true");
          interrputed = true;
        }
      }
    } finally {
      if (interrputed) {
        Thread.currentThread().interrupt();
      }

    }
  }

//  private String getNextMsg() {
//      while (true) {
//        try {
  // 导致无线循环,
//          return queue.take();
//        } catch (InterruptedException e) {
//          System.out.println("哈哈");
//          Thread.currentThread().interrupt();
//        }
//      }
//  }

  private void setMsg() {
    try {
      queue.put("哈哈");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    BlockingQueueMethodDemo blockingQueueMethodDemo = new BlockingQueueMethodDemo();
    blockingQueueMethodDemo.setMsg();
    blockingQueueMethodDemo.setMsg();
    blockingQueueMethodDemo.setMsg();
    // 中断开 线程
//    Thread.currentThread().interrupt();

    System.out.println(blockingQueueMethodDemo.getNextMsg());
    System.out.println(Thread.currentThread().isInterrupted());
  }
}
