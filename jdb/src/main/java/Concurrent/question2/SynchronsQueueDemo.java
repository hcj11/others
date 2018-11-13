package Concurrent.question2;

import java.util.concurrent.SynchronousQueue;

/**
 * 同步队列 Created by hcj on 18-6-5
 */
public class SynchronsQueueDemo {

  private final SynchronousQueue<String> synchronsQueue = new SynchronousQueue(false);

  public static void main(String[] args) throws InterruptedException {
    SynchronsQueueDemo synchronsQueueDemo = new SynchronsQueueDemo();

//    synchronsQueueDemo.transferForTake();
    synchronsQueueDemo.transferForPut();

  }

  // -> take -> put 等待获取数据
  public void transferForPut() throws InterruptedException {
    // 启动线程获取
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
//          Thread.sleep(1000);
          synchronsQueue.put("1");
          System.out.println("one");
          // 删除已上传的数据
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          synchronsQueue.put("2");
          System.out.println("two");
          // 删除已上传的数据
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    System.out.println("wd1");
//    synchronsQueue.put("111");
    System.out.println(synchronsQueue.take());
//    System.out.println(synchronsQueue);

  }

  // 公平交易-> put->take  等待接受数据 queue
  public void transferForTake() throws InterruptedException {
    // 启动线程获取
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println(synchronsQueue.take());
          System.out.println("one");
          // 删除已上传的数据
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          System.out.println(synchronsQueue.take());
          System.out.println("two");
          // 删除已上传的数据
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    System.out.println("wd1");
//    synchronsQueue.put("111");
    synchronsQueue.put("112");
//    System.out.println(synchronsQueue);

  }
}










