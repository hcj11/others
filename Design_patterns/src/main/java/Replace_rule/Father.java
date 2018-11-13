package Replace_rule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hcj on 18-7-14
 */
public class Father {

  public void doSomething(HashMap map){
    if(this instanceof Son){
        ((Son) this).doSomething((Map)map);
    }
      System.out.println("执行父类map");

  }
}
