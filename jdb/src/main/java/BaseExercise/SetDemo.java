package BaseExercise;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by hcj on 18-7-29
 */
public class SetDemo {
    public   static  void main(String[] args){
      HashSet<Pet> objects = new HashSet<>();
      TreeSet<String> objects1 = new TreeSet<>();
      LinkedHashSet<String> objects2 = new LinkedHashSet<>();

      Collections.addAll(objects1,"D,AA,A,A,b,c".split(","));
      System.out.println(objects1);

      Collections.addAll(objects2,"D,AA,A,A,b,c".split(","));
      System.out.println(objects2);
    }
}
