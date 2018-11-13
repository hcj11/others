package DeadlockTest;

import Concurrent.Deadlock.LeftRightDeadlock;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 * 静态锁顺序死锁测试 Created by hcj on 18-5-6
 */
public class DeadlockTest {

  //  private ExecutorService executorService = Executors.newCachedThreadPool();
  private static ExecutorService executorService = Executors.newFixedThreadPool(10);

  private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(11);

  public void test() throws BrokenBarrierException, InterruptedException {

    LeftRightDeadlock leftRightDeadlock = new LeftRightDeadlock();


    for (int i = 0; i < 10; i++) {
      int finalI = i;
    // 对于 newFixedThreadPool  若 executorService 的corePoolSize <10 那么 有栅栏限制 将阻塞
      //
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          try {
//            System.out.println(finalI);
            cyclicBarrier.await();
          }
          catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
          }

//          leftRightDeadlock.rightLeft();
          if (finalI % 2 == 0) {
            leftRightDeadlock.rightLeft();
          } else {
            leftRightDeadlock.leftRight();
          }
        }
      });
    }
    cyclicBarrier.await();

  }
    public   static  void main(String[] args) throws BrokenBarrierException, InterruptedException {
      DeadlockTest deadlockTest = new DeadlockTest();
      deadlockTest.test();

      executorService.shutdown();

    }
}
