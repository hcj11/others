package Concurrent.ConcurrentLinkedQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-4-6
 */
@Setter
@Getter
public class ConcurrentLinkedQueueDemo {

  private Integer count = 0;
  // 并发队列,非阻塞,  将数据放入队列,并最终进行计算
  private final  static ConcurrentLinkedQueue<Integer> ids = new ConcurrentLinkedQueue<>();
  private final  List<Thread> lists=new LinkedList<>();

  public int getCount() {

    return count;
  }

  public void setCount(int count) {
//    System.out.println("Set count :" + count);
    this.count = count;
  }

  public static void main(String[] args) {

    ConcurrentLinkedQueueDemo commonDemo = new ConcurrentLinkedQueueDemo();
    ConcurrentLinkedQueueMain(commonDemo);

  }

  public static void ConcurrentLinkedQueueMain(ConcurrentLinkedQueueDemo commonDemo) {
    commonDemo.threadStart();

    // 删除元素?
//    Integer peek = ids.peek();
    // 等待线程死亡
    for(Thread thread:commonDemo.getLists()){
      try {
        thread.join(); // timeout=0s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    int sum=0;
//    System.out.println(Arrays.toString(ids.toArray()));
//    //  peek()获取元素不移除头结点.
//    Integer peek = ids.peek();
//    System.out.println(peek); // 获取头元素
////    System.out.println(Arrays.toString(ids.toArray()));
//    //  poll() 获取元素并且在队列中移除[FIFO]
//    Integer poll = ids.poll(); // 移除元素
//    System.out.println(poll);
//    System.out.println(Arrays.toString(ids.toArray()));
    for (Integer id:ids){
//      System.out.println("LinkedQueue: "+id);
      sum+=id;
    }
    if(sum!=55){
      System.out.println("result :" + sum);

    }
    // 清 空
    ids.clear();
  }

  public void threadStart() {
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          plusOper(finalI);
        }
      });
      thread.start();
      lists.add(thread);
    }

  }

  public void plusOper(int finalI) {
    ids.offer(finalI);

  }
}
