package Concurrent;

import static Concurrent.ConcurrentHarness.measurePerf;
import static Concurrent.commoned.commonDemoExecutor.awaitTerminations;

import Concurrent.ConcurrentLinkedQueue.ConcurrentLinkedQueueDemo;
import Concurrent.ConcurrentLinkedQueue.ConcurrentLinkedQueueExecutorDemo;
import Concurrent.CountDownLatch.CountDownLatchDemo;
import Concurrent.CountDownLatch.CountDownLatchExecutorDemo;
import Concurrent.Future.CountFutureTaskDemo;
import Concurrent.Future.CountFutureTaskExecutorDemo;
import Concurrent.Semaphore.CountSemaphoreDemo;
import Concurrent.Semaphore.CountSemaphoreExecutorDemo;
import Concurrent.Synchronized.SynchronizedDemo;
import Concurrent.Synchronized.SynchronizedExecutorDemo;
import Concurrent.commoned.commonDemo;
import Concurrent.commoned.commonDemoExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ConcurrentExecutorHarness {
//  public static final ExecutorService executorService = Executors.newFixedThreadPool(10);
  public static final ExecutorService executorService = Executors.newCachedThreadPool();
  // 单线程运转 保持任务在队列中的顺序来串行执行
//  public static final ExecutorService executorService = Executors.newSingleThreadExecutor();


  public static void main(String[] args) throws InstantiationException, IllegalAccessException {


//    measurePerf(commonDemoExecutor::commonMain,
//        commonDemoExecutor.class.newInstance(), "common  done in: ");
//
    // 循环构造多个对象进行同步
//    measurePerf(SynchronizedExecutorDemo::SynchronizedMain,
//        SynchronizedExecutorDemo.class.newInstance(), "synchronized  done in: ");
//
//    measurePerf(ConcurrentLinkedQueueExecutorDemo::ConcurrentLinkedQueueMain,
//        ConcurrentLinkedQueueExecutorDemo.class.newInstance(), "ConcurrentLinkedQueue  done in: ");

    measurePerf(CountDownLatchExecutorDemo::countDownLatchMain, CountDownLatchExecutorDemo.class.newInstance(),
        "CountDownLatch done in: ");
//    measurePerf(CountSemaphoreExecutorDemo::SemaphoreMain, CountSemaphoreExecutorDemo.class.newInstance(),
//        "Semaphore done in: ");
//    measurePerf(CountFutureTaskExecutorDemo::ConcurrentFutureMain, CountFutureTaskExecutorDemo.class.newInstance(),
//        "FutureTask done in: ");
    executorService.shutdown();


  }


}