package bean.AwareHello;

import bean.Student;
import java.io.IOException;
import java.net.URL;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by hcj on 18-7-14
 */
public class AwareHelloBeanFactory implements BeanFactoryAware {

  private BeanFactory beanFactory;
  // 扩展
  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
      this.beanFactory=beanFactory;
  }
  public void testHello(){
    beanFactory.getBean("student", Student.class).getname();
  }
}
