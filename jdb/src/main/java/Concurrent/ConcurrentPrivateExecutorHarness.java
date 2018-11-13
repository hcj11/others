package Concurrent;

import static Concurrent.ConcurrentHarness.measurePerf;

import Concurrent.ConcurrentLinkedQueue.ConcurrentLinkedQueueExecutorDemo;
import Concurrent.CountDownLatch.CountDownLatchExecutorDemo;
import Concurrent.Future.CountFutureTaskExecutorDemo;
import Concurrent.Semaphore.CountSemaphoreExecutorDemo;
import Concurrent.Synchronized.SynchronizedExecutorDemo;
import Concurrent.commonExecutorService.countExecutorService;
import Concurrent.commoned.commonDemoExecutor;
import Concurrent.commoned.commonDemoPrivateExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentPrivateExecutorHarness {


  public static void main(String[] args) throws InstantiationException, IllegalAccessException {


    measurePerf(commonDemoPrivateExecutor::commonMain,
        commonDemoPrivateExecutor.class.newInstance(), "common  done in: ");

//    measurePerfByPrivateExecutor(commonDemoPrivateExecutor::commonMain,
//        commonDemoPrivateExecutor.class.newInstance(), "common  done in: ", countExecutorService.class.newInstance());


//    measurePerfByPrivateExecutor(SynchronizedPrivateExecutorDemo::SynchronizedMain,
//        SynchronizedExecutorDemo.class.newInstance(), "synchronized  done in: ");
//
//    measurePerfByPrivateExecutor(ConcurrentLinkedQueueExecutorDemo::ConcurrentLinkedQueueMain,
//        ConcurrentLinkedQueueExecutorDemo.class.newInstance(), "ConcurrentLinkedQueue  done in: ");
//
//    measurePerfByPrivateExecutor(CountDownLatchExecutorDemo::countDownLatchMain, CountDownLatchExecutorDemo.class.newInstance(),
//        "CountDownLatch done in: ");
//    measurePerfByPrivateExecutor(CountSemaphoreExecutorDemo::SemaphoreMain, CountSemaphoreExecutorDemo.class.newInstance(),
//        "Semaphore done in: ");
//    measurePerfByPrivateExecutor(CountFutureTaskExecutorDemo::ConcurrentFutureMain, CountFutureTaskExecutorDemo.class.newInstance(),
//        "FutureTask done in: ");


  }


}