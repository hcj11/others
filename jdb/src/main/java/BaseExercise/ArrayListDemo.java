package BaseExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by hcj on 18-7-29
 */
public class ArrayListDemo {
    public   static  void main(String[] args){
      ArrayList<Pet> list = new ArrayList<>();
      Random random = new Random(47);
      for (int i=0;i<10;i++){
        list.add(new Pet(i));
      }
      System.out.println(list);
      // index 0-3
      List<Pet> pets = list.subList(0, 3);
      System.out.println("子列表： "+pets);

      // 初始list 交换位置
      Collections.shuffle(list,random);
      System.out.println("交换位置 :"+ list);

      // 求补集， 删除和pets 共有的元素, 根据对象地址进行删除?
      list.removeAll(pets);
      System.out.println("删除 :"+list);
      List<Pet> pets1 = list.subList(0, 3);

      // 求交集 -> list ,只保留和pets 共有的元素
      list.retainAll(pets1);
      System.out.println("求交集 :"+ list);

      List<Pet> pets2 = list.subList(0, 1);
      System.out.println(list.containsAll(pets2));;
      // 替换replace
      list.set(0,new Pet(11));
      System.out.println(list);





    }
}
