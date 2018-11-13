package bean.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by hcj on 18-7-15
 */
public class MyBeanPostProcessor implements BeanPostProcessor{

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    // 返回构造的bean, 准备lifecycle
    System.out.println("BeanPostProcessor 对bean的预处理");
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    // 返回构造的bean
    System.out.println("BeanPostProcessor 对bean的后置处理");
    return bean;
  }
}
