package Concurrent.question2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import org.junit.Test;

/**
 * Created by hcj on 18-5-27
 */
public class question2 {

  private int count = 1;

  /**
   * 模仿 countdownLatch  一次性的栅栏 Created by hcj on 18-5-27.
   */
//  @Test
//  public void ready() {
//    List<Runnable> runnables = new ArrayList<>();
//    for (int i = 0; i < 10; i++) {
//      runnables.add(new Provider());
//    }
//    List<Thread> threads = runTasks(runnables);
//
//
//    // 等所有线程执行结束
//    for(Thread thread:threads){
//      try {
//        thread.join();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }
//    System.out.println(count);
//  }
  @Test
  public void ready1() {

    for (int j = 0; j < 200; j++) {
      List<Runnable> runnables = new ArrayList<>();
      for (int i = 0; i < 10; i++) {// 0,9 => 10
        runnables.add(new Provider());
      }
      List<Thread> threads = startTasks(runnables, 0);
//      for (Thread thread : threads) {
//        try {
//          thread.join(100);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }
      if (count != 11) {
        // 等所有线程执行结束
        System.out.println("result:==== " +count);
      }
      count = 1; //

    }

  }

  List<Thread> startTasks( List<Runnable> tasks,final int iterations) {
    ArrayList<Thread> objects = new ArrayList<>();
    final Phaser phaser = new Phaser() {
      // 自定义结束标志  有顺序的结束 subPhaser
      protected boolean onAdvance(int phase, int registeredParties) {
//        System.out.println("pharse: ======  "+phase + " registeredParties ===="+registeredParties);
//        registeredParties = subParties + Parties
        return  phase >= iterations || registeredParties == 0;
      }
    };
    phaser.register();
//    System.out.println(phaser.getPhase());

    for (final Runnable task : tasks) {
        phaser.register();
//      System.out.println("subPhaser: ===="+phaser.getPhase());
        Thread thread = new Thread() {
        public void run() {

          do {
            putdata(task);
            phaser.arriveAndAwaitAdvance();
          } while (!phaser.isTerminated());
          // 同时执行方法

        }

      };

      objects.add(thread);
      thread.start();
    }
    phaser.arriveAndDeregister(); // deregister self, don't wait

    phaser.register();
    while (!phaser.isTerminated()) {
      phaser.arriveAndAwaitAdvance();
    }

    return objects;
  }

//  List<Thread> runTasks(List<Runnable> tasks) {
//    ArrayList<Thread> objects = new ArrayList<>();
//
//    final Phaser phaser = new Phaser(2); // "1" to register self
//    // create and start threads
//    for (final Runnable task : tasks) {
//      phaser.register();
//      Thread t1 = new Thread(() -> {
//        phaser.arriveAndAwaitAdvance(); // await all creation
//        task.run();
//      });
//      objects.add(t1);
//      t1.start();
//    }
//
//    // allow threads to start and deregister self
//    phaser.arriveAndDeregister();
//    return objects;
//  }

  public synchronized void putdata(Runnable runnable) {
    runnable.run();

  }
  class Provider implements Runnable {

    @Override
    public void run() {
//      System.out.println(count);
      putCount();

    }

    public  void putCount() {
//      System.out.println(count);
      ++count;
    }
  }
}


