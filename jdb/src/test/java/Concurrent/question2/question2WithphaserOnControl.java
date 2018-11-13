package Concurrent.question2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import org.junit.Test;

/**
 * 将遍历的行为交给phaser Created by hcj on 18-5-27
 */
public class question2WithphaserOnControl {

  private int count = 1;

  /**
   * 模仿 countdownLatch  一次性的栅栏 Created by hcj on 18-5-27.
   */
  @Test
  public void ready1() {
    int allCount = 5;
    int iterations = 0;
// 1 0-19 => 1+0-19 =20  => 1+20=21

    // 5 * 200 = 1000
//    for (int j = 0; j < 2000; j++) {
    for (int i = 0; i < 5; i++) {// 0,9 => 10
      startTasks(new Provider(), iterations, allCount);
    }

    if (count != 61) { //46
      // 等所有线程执行结束
      System.out.println("result:==== " + count);
    }
    count = 1; //

//    }

  }

  List<Thread> startTasks(Runnable task, final int iterations, int allCount) {
    ArrayList<Thread> objects = new ArrayList<>();
    // 10 *
    final Phaser phaser = new Phaser() {
      // 自定义结束标志  有顺序的结束 subPhaser
      protected boolean onAdvance(int phase, int registeredParties) {
//        System.out.println("pharse: ======  "+phase + " registeredParties ===="+registeredParties);
//        registeredParties = subParties + Parties
        return phase >= iterations || registeredParties == 0;
      }
    };

    phaser.register();
    phaser.register();
    Thread thread = new Thread() {

      public void run() {

        do {
          for (int i = 0; i < 200; i++) {
            putdata(task);
          }
          phaser.arriveAndAwaitAdvance();
        } while (!phaser.isTerminated());
        // 同时执行方法

      }

    };

    objects.add(thread);
    thread.start();

    phaser.arriveAndDeregister(); // deregister self, don't wait

    phaser.register();
    while(!phaser.isTerminated())

  {
    phaser.arriveAndAwaitAdvance();
  }

    return objects;
}

  public synchronized void putdata(Runnable runnable) {
    runnable.run();

  }

class Provider implements Runnable {

  @Override
  public void run() {
//      System.out.println(count);
    putCount();

  }

  public void putCount() {
//      System.out.println(count);
    ++count;
  }
}
}


