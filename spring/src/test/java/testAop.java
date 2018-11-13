import bean.extend.MyClassPathXmlApplication;
import bean.proxy.baseTest.baseTest;
import bean.proxy.jdkProxy.jdkProxy;
import bean.proxy.jdkProxy.jdkProxyImpl;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hcj on 18-7-15
 */
public class testAop {
  @Test
  public void testForJdk(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new MyClassPathXmlApplication(
        "tx.xml");
//    String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
    // jdk 代理, 通过
    classPathXmlApplicationContext.getBean("");
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
    BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition("");

    jdkProxy jdkProxyImpl = classPathXmlApplicationContext.getBean("jdkProxyImpl", jdkProxy.class);
    jdkProxyImpl.test();

  }

  @Test
  public void test(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new MyClassPathXmlApplication(
        "tx.xml");
    baseTest baseTest = classPathXmlApplicationContext.getBean("baseTest", baseTest.class);
    baseTest.hello();

  }
}
