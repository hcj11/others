package BoundedTest;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池回调 Created by hcj on 18-5-6
 */
public class CallbackTest {

  // 测试线程是否按照如期的方式进行扩展
  private final int Max_SiZE = 10;
  private final ThreadPoolExecutor executorService1;
  private TestThread testThread;

  public ThreadPoolExecutor getExecutorService1() {
    return executorService1;
  }

  public CallbackTest() {
    ExecutorService executorService = Executors.newFixedThreadPool(Max_SiZE);
//    ExecutorService executorService = Executors.newCachedThreadPool();
//    ExecutorService executorService = Executors.newSingleThreadExecutor();

    executorService1 = (ThreadPoolExecutor) executorService;
    testThread = new TestThread();
    executorService1.setThreadFactory(testThread);
    // MaximumPoolSize 对于newFixedThreadPool 的线程不起作用呀，还是10个基本线程？
    executorService1.setMaximumPoolSize(12);
  }

  public void testPoolExpansion() {

    for (int i = 0; i < Max_SiZE *10; i++) {

      executorService1.execute(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(Long.MAX_VALUE);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
      });
    }

    for (int i = 0; i < 20 && testThread.count.get() < Max_SiZE; i++) {
      System.out.println(testThread.count.get());
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    assertTrue(testThread.count.get() == Max_SiZE);

  }


  public class TestThread implements ThreadFactory {

    private final AtomicInteger count = new AtomicInteger(0);
    private final ThreadFactory threadFactory = Executors.defaultThreadFactory();

    // 已创建线程数量
    @Override
    public Thread newThread(Runnable r) {

      Thread thread = threadFactory.newThread(r);
      count.incrementAndGet();
      return thread;
    }
  }

  public static void main(String[] args) {
    // main 主方法的生命周期
    CallbackTest callbackTest = new CallbackTest();
    callbackTest.testPoolExpansion();
    ThreadPoolExecutor executorService1 = callbackTest.getExecutorService1();

    executorService1.shutdownNow();
    try {
      executorService1.awaitTermination(1000L, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
