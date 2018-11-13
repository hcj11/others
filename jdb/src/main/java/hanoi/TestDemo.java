package hanoi;

import java.util.ArrayList;

/**
 * Created by hcj on 18-3-11
 */
public class TestDemo {
      public   static  void main(String[] args){
        ArrayList<Object> objects = new ArrayList<>();
          objects.add("1");
        objects.add("2");
        objects.remove(0);
        // 删除索引为0的1，之后会自动前置list数据
        System.out.println(objects.get(0));
      }
}
