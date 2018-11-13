package Replace_rule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hcj on 18-7-14
 */
public class Client {
    public   static  void main(String[] args){
      // 符合里式替换 ,  子类将参数定的宽松一些,则会先调用父类的方法, 做业务逻辑的控制.

      Father father = new Father();
      HashMap objectHashMap = new HashMap<>();
      father.doSomething(objectHashMap);

      // 传递是Map类型 和接受的类型相同则会进入son方法,
      Map objectObjectMap = new HashMap<>();
      Son son = new Son();
      son.doSomething(objectObjectMap);


    }
}
