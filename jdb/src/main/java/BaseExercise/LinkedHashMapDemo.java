package BaseExercise;

import java.util.LinkedHashMap;

/**
 * Created by hcj on 18-7-29
 */
public class LinkedHashMapDemo {

  public static void main(String[] args) {
    LinkedHashMapDemo linkedHashMapDemo = new LinkedHashMapDemo();
//    linkedHashMapDemo.demo();
  double i = 0.44;
  System.out.println(i>0.4);

  }

  private void demo() {
    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16, 0.75f,true);
    // 默认采用lru 最近最少使用原则， 那么最久未使用的key，会排到前面
    map.put("3", "2");
    map.put("1", "4");
    map.put("5", "6");
    System.out.println("插入顺序： " + map);
    map.get("3");
//    map.get("5");
    System.out.println("LRU原则顺序： " + map);

  }
}
