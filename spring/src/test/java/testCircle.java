import bean.Circle.TestA;
import bean.Circle.TestB;
import bean.Circle.TestC;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hcj on 18-7-14
 */
public class testCircle {

  //  @Test(expected = BeanCurrentlyInCreationException.class)
//  public void hello(){
//    // 对于通过构造器出现的循环依赖问题,  是无法解决
//    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//        "testBean.xml");
//    TestA testA = (TestA) classPathXmlApplicationContext.getBean("testA");
//    testA.getName();
//    TestB testB = (TestB) classPathXmlApplicationContext.getBean("testB");
//    testB.getName();
//    TestC testC = (TestC) classPathXmlApplicationContext.getBean("testC");
//    testC.getName();
//  }
  // 单例依赖注入, 单例工厂的识别
  @Test
  public void setWithSinglton() {
    // 对于通过构造器出现的循环依赖问题,  是无法解决
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "testBean.xml");
//    classPathXmlApplicationContext.setAllowBeanDefinitionOverriding(false);
    classPathXmlApplicationContext.setAllowCircularReferences(false);
    TestA testA = classPathXmlApplicationContext.getBean("testA", TestA.class);
    testA.getName();
//    TestB testB = (TestB) classPathXmlApplicationContext.getBean("testB");
//    testB.getName();
//    TestC testC = (TestC) classPathXmlApplicationContext.getBean("testC");
//    testC.getName();
  }

  @Test
  public void setWithPrototype() {

  }


}
