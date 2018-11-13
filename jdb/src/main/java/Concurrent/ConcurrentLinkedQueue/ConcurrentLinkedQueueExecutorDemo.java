package Concurrent.ConcurrentLinkedQueue;

import static Concurrent.ConcurrentExecutorHarness.executorService;
import static Concurrent.commoned.commonDemoExecutor.awaitTerminations;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class ConcurrentLinkedQueueExecutorDemo {

  private Integer count = 0;
  // 并发队列,非阻塞,  将数据放入队列,并最终进行计算
  private final  static ConcurrentLinkedQueue<Integer> ids = new ConcurrentLinkedQueue<>();

  public int getCount() {

    return count;
  }

  public void setCount(int count) {
//    System.out.println("Set count :" + count);
    this.count = count;
  }

  public static void main(String[] args) {
    ConcurrentLinkedQueueExecutorDemo commonDemo = new ConcurrentLinkedQueueExecutorDemo();
    ConcurrentLinkedQueueMain(commonDemo);

  }

  public static void ConcurrentLinkedQueueMain(ConcurrentLinkedQueueExecutorDemo commonDemo) {

    commonDemo.threadStart();
    // 等待线程死亡
    awaitTerminations();
    int sum=0;
    for (Integer id:ids){
      sum+=id;
    }
    System.out.println("result :" + sum);
    ids.clear();
  }

  public void threadStart() {
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          plusOper(finalI);
        }
      });
    }

  }

  public void plusOper(int finalI) {

//    System.out.println("input: "+finalI);
    ids.add(finalI);
  }
}
