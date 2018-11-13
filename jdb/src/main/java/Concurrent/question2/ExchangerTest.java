package Concurrent.question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * 交换器，
 * Created by hcj on 18-5-28.
 */
public class ExchangerTest {

  public static void main(String[] args) {
    Exchanger<List<Integer>> exchanger = new Exchanger<>();
    Exchanger<List<Integer>> exchanger1 = new Exchanger<>();
    // 相同的管道 , 在生产者和消费者 同时在相同的exchange下传递数据时，就会出现资源不均匀的问题
//    new Consumer(exchanger).start();
//    System.out.println("哈哈哈1-consumer");
    new Producer(exchanger).start();
    System.out.println("哈哈哈2-producer");
//    try {
//      Thread.sleep(10000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    new Producer(exchanger).start();
//    System.out.println("哈哈哈3-producer");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Consumer(exchanger).start();
    System.out.println("哈哈哈4-consumer");

    new Consumer(exchanger).start();
    System.out.println("哈哈哈5-consumer");


    // 线程未关闭，导致jvm的无法关闭

//    new Producer(exchanger).start();
//    System.out.println("哈哈哈4");
//    new Producer(exchanger).start();
  }

}

class Producer extends Thread {

  List<Integer> list = new ArrayList<>();
  Exchanger<List<Integer>> exchanger = null;

  public Producer(Exchanger<List<Integer>> exchanger) {
    super();
    this.exchanger = exchanger;
  }

  @Override
  public void run() {
    Random rand = new Random();
    for (int i = 0; i < 10; i++) {
      list.clear();
      list.add(rand.nextInt(10000));
      list.add(rand.nextInt(10000));
      list.add(rand.nextInt(10000));
      list.add(rand.nextInt(10000));
      list.add(rand.nextInt(10000));
      try {
        list = exchanger.exchange(list);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

class Consumer extends Thread {

  List<Integer> list = new ArrayList<>();
  Exchanger<List<Integer>> exchanger = null;

  public Consumer(Exchanger<List<Integer>> exchanger) {
    super();
    this.exchanger = exchanger;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        // 接受到同一个线程的数据， 或者是其他线程
        list = exchanger.exchange(list);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println(list.toString());
//      System.out.print(list.get(0) + ", ");
//      System.out.print(list.get(1) + ", ");
//      System.out.print(list.get(2) + ", ");
//      System.out.print(list.get(3) + ", ");
//      System.out.println(list.get(4) + ", ");
    }
  }
} 