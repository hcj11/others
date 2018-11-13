package BaseExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by hcj on 18-7-29
 */
public class LinkedListDemo {
    public   static  void main(String[] args){
      LinkedList<Pet> list = new LinkedList<>();
      // stack 先进先出
      for (int i=0;i<10;i++){
        // 在栈顶添加元素
        list.addFirst(new Pet(i));
        // 构建栈和队列
        list.addLast(new Pet(i));
//            list.element()
      }

      // 删除栈顶元素
      System.out.println(list.remove());; //返回删除的元素
      System.out.println(list.removeFirst());//返回删除的元素
      System.out.println(list.poll());//返回删除的元素
      System.out.println(list);
      // 利用父类Collection的方法，根据内存地址进行删除 ,
      // Exception in thread "main" java.util.ConcurrentModificationException
      List<Pet> pets = list.subList(0, 1);
      list.retainAll(pets);

      System.out.println("交集: "+list);

//      List<Pet> pets1 = list.subList(0, 1);
//      list.removeAll(pets1);
//      System.out.println("补集: "+list);


    }
}
