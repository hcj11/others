package BaseExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by hcj on 18-7-29
 */
public class MapDemo {
    public   static  void main(String[] args){
//      System.out.println(1<<2);
//      System.out.println(1<<4);
//      System.out.println(1<<8);
//      System.out.println(1<<16);
//      System.out.println(16>>>2);
//      System.out.println(16>>>4);
//      System.out.println(16>>>8);
//    System.out.println(1<<30);
//      int i = (16 >>> 8) ^ (16 >>> 4);
//      int j= 33 & 1122211121;
//      System.out.println(j);

//      System.out.println(i);
//      demo18();
//      demo19();
//      demo24();
//      demo25();
        demo26();
    }

  private static void demo26() {
    HashMap<String, String> map = new HashMap<String, String>(32,0.75f);
    //
    for (int i=0;i<13;i++){
      //扩容一次？
      map.put(i+"",i+"");
      // 进行了一次扩容处理，
    }


  }

  private static void demo25() {
    HashMap<Object, Object> map = new HashMap<>();
    map.put(null,null);
    map.put(1,null);

  }

  private static void demo24() {
    LinkedHashMap<String, String> map = new LinkedHashMap<>();
    map.put("3","2");
    map.put("1","4");
    map.put("5","6");
    System.out.println(map);
    TreeSet<String> treeSet = new TreeSet<>(map.keySet());
    for (String ss:treeSet){
      map.put(ss,map.get(ss));
    }
    System.out.println(treeSet);
    // 顺序无变化,仍是以刚开始的插入顺序 ，
    System.out.println(map);
  }

  private static void demo19() {
    HashMap<String, String> map = new HashMap<>();
    map.put("3","2");
    map.put("1","4");
    map.put("5","6");
    Set<Entry<String, String>> entries = map.entrySet();

    for (Entry<String, String> entry:entries){
      System.out.println(entry.hashCode());
    }

    Set<String> strings = map.keySet();
    TreeSet<String> treeSet = new TreeSet<>(strings);
    // 是按照 treeSet 的顺序排序的 -》  1,3,5
    HashSet<String> objects = new HashSet<>(treeSet);
    System.out.println("HashSet 的结果");
    System.out.println(objects);

    LinkedHashSet<String> strings1 = new LinkedHashSet<>(treeSet);
    System.out.println("LinkedHashSet 的结果");
    System.out.println(strings1);

  }

  private static void demo18() {
    HashMap<String, String> map = new HashMap<>();
    map.put("3","2");
    map.put("1","4");
    map.put("5","6");
    Set<Entry<String, String>> entries = map.entrySet();

    for (Entry<String, String> entry:entries){
      System.out.println(entry.hashCode());
    }

    Set<String> strings = map.keySet();
    TreeSet<String> treeSet = new TreeSet<>(strings);
    LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
    // 按照顺序排列 1,3,5
    for (String ss:treeSet){
      stringStringLinkedHashMap.put(ss,map.get(ss));
    }
    System.out.println(stringStringLinkedHashMap);

  }
}
