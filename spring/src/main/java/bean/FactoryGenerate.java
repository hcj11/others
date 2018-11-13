package bean;

import bean.Circle.TestA;

/**
 * Created by hcj on 18-7-14
 */
public class FactoryGenerate {
  // 专注创建TestA的静态
  public static TestA newInstance(){
    return new TestA();
  }

}
