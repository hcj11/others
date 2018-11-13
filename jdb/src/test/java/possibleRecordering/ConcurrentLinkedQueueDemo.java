package possibleRecordering;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.junit.Test;

/**
 * 非阻塞队列 Created by hcj on 18-5-24
 */
public class ConcurrentLinkedQueueDemo {

  @Test
  public void test() {
    ConcurrentLinkedQueue<Integer> objects = new ConcurrentLinkedQueue<>();
    objects.add(1);
    Integer poll = objects.poll();
    System.out.println(poll);
    System.out.println(objects);

  }

  @Test
  public void test1() {
    ConcurrentLinkedQueue<Integer> objects = new ConcurrentLinkedQueue<>();
    objects.add(1);
    Integer peek = objects.peek();
    System.out.println(peek);
    System.out.println(objects);

  }

  @Test
  public void test3() {
    ArrayList b = new ArrayList();
    for (ArrayList a = b, p = b, q = null; ; ) {
      System.out.println(p + ":" + q);
    }
  }


}
