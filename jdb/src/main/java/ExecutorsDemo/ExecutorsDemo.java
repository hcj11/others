package ExecutorsDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hcj on 18-7-28
 */
public class ExecutorsDemo {
//  private ExecutorsUnit executorsUnit = new ExecutorsUnit(3, 3, 10, TimeUnit.SECONDS
//      , new ArrayBlockingQueue<>(1,false));

  // 采用移交队列，会快一点，因为是线程级的队列
  // 无界的阻塞队列，
  private ExecutorsUnit executorsUnit = new ExecutorsUnit(3, 30, 10, TimeUnit.SECONDS
      , new LinkedBlockingQueue<>(1));

  private static AtomicInteger atomicInteger = new AtomicInteger(1);
  public ExecutorsDemo(){
    // queue , fair =false 不公平， 提高吞吐， 存在饥饿死锁风险.

    //  可以保证部分任务的继续执行， 而终止一部分任务，
//     executorsUnit.setRejectedExecutionHandler(new AbortPolicy());
    //  可以保证部分任务的继续执行， 而一部分任务将被抛弃
//     executorsUnit.setRejectedExecutionHandler(new DiscardPolicy());
    //  可以保证部分任务的继续执行， 而最老的任务将被抛弃
//    executorsUnit.setRejectedExecutionHandler(new DiscardOldestPolicy());
    // 改到主线程进行调用， 并且由于执行任务需要时间，短时间不会在提交任务
//    executorsUnit.setRejectedExecutionHandler(new CallerRunsPolicy());
//    当前线程: pool-1-thread-1
//    当前线程: pool-1-thread-2
//    当前线程: pool-1-thread-3
//    当前线程: pool-1-thread-1

  }
  public static void main(String[] args) {
    ExecutorsDemo executorsDemo = new ExecutorsDemo();
    executorsDemo.test();
    // 构建线程测试
    executorsDemo.startRun();
    System.out.println(atomicInteger.get());
    executorsDemo.getExecutorsState();
  }

  private void getExecutorsState() {
    System.out.println(executorsUnit);

  }

  private void startRun() {
    for (int i=0;i<30;i++){
      try{
        executorsUnit.submit(new Runnable() {
          @Override
          public void run() {
            test();
          }
        });
      }catch (RejectedExecutionException e){
        // 线程和 此时采用丢弃策略，将放弃最旧的任务，并等待，
        System.out.println("哈哈:");
      }



    }

    // 无法知道它结束的时间.
  }

  private void test() {
    int i = atomicInteger.getAndAdd(1);

    System.out.println(i);
    // int corePoolSize, int maximumPoolSize, long keepAliveTime,
    //      TimeUnit unit,
    //      BlockingQueue<Runnable> workQueue
    // 构建有长度的 以及有线程长度的线程池
    System.out.println("当前线程: "+Thread.currentThread().getName());
    System.out.println(executorsUnit);
    try {
      // 1000s
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
