package BaseExercise;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by hcj on 18-7-29
 */
public class PriorityQueueDemo extends Object{
    public   static  void main(String[] args){
//      demo28();
      demo29();
    }

  private static void demo29() {
    PriorityQueue<PriorityQueueDemo> objects = new PriorityQueue<>(10);
    for (int i=0;i<10;i++){
      // 16 位
      objects.offer(new PriorityQueueDemo());
    }
    // Exception in thread "main" java.lang.ClassCastException: BaseExercise.PriorityQueueDemo cannot be cast to java.lang.Comparable
    System.out.println(objects);
  }

  private static void demo28() {
    Random random = new Random(47);
//      PriorityQueue<Double> objects = new PriorityQueue<>(10, Collections.reverseOrder());
    PriorityQueue<Double> objects = new PriorityQueue<>(10);
    for (int i=0;i<10;i++){
      // 16 位
      Double v = random.nextDouble();
      objects.offer(v);
    }

    // 默认排序规则
    System.out.println("插入后的顺序： "+objects);// 未排序，而是在输出的时候排序
    for (int i=0;i<10;i++){
      System.out.println(objects.poll());;
    }
  }

}
