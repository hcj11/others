package bean.Circle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 循环依赖
 * Created by hcj on 18-7-14
 */
public class Circle {

  /**
   * 循环依赖问题:
   * Created by hcj on 18-7-14.
   */
  public   static  void main(String[] args){
//    // 单例模式可以解决依赖问题,  而对于多例来说会报异常
//    // 对于
//      ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//          "testBean.xml");
//      TestA testA = (TestA) classPathXmlApplicationContext.getBean("testA");
//      testA.getName();
//      TestB testB = (TestB) classPathXmlApplicationContext.getBean("testB");
//      testB.getName();
//      TestC testC = (TestC) classPathXmlApplicationContext.getBean("testC");
//      testC.getName();

    }
}
