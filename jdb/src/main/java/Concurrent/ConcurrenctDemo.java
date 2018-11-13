package Concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hcj on 18-3-11
 */
public class ConcurrenctDemo {
  /**
   * 写一个10线程的小程序，线程编号从1到10。同时让这10个线程往1个全局变量做加法，值即它自己的编号。

   a. 在不使用任何机制求结果，多观察几次

   b. 请使用synchronized关键字

   c. 请使用java.util.concurrent.Lock

   d. 请使用ConcurrentLinkedQueue

   e. 请使用CountDownLatch

   f. 请使用Semaphore

   g. 哪个方法性能更好？为什么？有没有优化的空间？
   * **/
    public   static  void main(String[] args){
      Thread.currentThread().getName();
      Vector<Object> objects = new Vector<>();
      Collection<Object> objects1 = Collections.synchronizedCollection(objects);
      // 线程安全同步类,对比于Vector来进行 方法的扩展
      List<Object> objects2 = Collections.synchronizedList(new ArrayList<>());

      ArrayList<Object> objects3 = new ArrayList<>();
      for(Object o:objects3){

      }

      CopyOnWriteArrayList<Object> objects4 = new CopyOnWriteArrayList<>();
      // CopyOnWriteArrayList 添加事实不可变对象 ,保证对象安全访问.
      objects4.add(Collections.synchronizedList(new ArrayList<>()));
      Thread.currentThread().interrupt();
      Thread.interrupted();

    }
}
