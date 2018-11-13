package Concurrent.commoned;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class commonDemo {

  private Integer count = 0;
  private List<Thread> lists = new LinkedList<>();

  public static void main(String[] args) {
      commonDemo commonDemo = new commonDemo();
      commonMain(commonDemo);


  }
  public static void commonMain(commonDemo commonDemo) {

    // 计算时间
    commonDemo.threadStart();
    // 线程等待结束  注意主线程和副线程
    for (Thread thread : commonDemo.getLists()) {
      try {
        thread.join(); // timeout=0s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

//    if(commonDemo.getCount()!=55){
//      System.out.println("Result: " + commonDemo.getCount());
//    }
    commonDemo.setCount(0);
  }


  public void threadStart() {
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          count += finalI;
        }
      });
      thread.start();
      lists.add(thread);
    }
  }



}
