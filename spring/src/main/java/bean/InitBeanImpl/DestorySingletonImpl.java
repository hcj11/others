package bean.InitBeanImpl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * 销毁的子实现类
 * Created by hcj on 18-7-14
 */
public class DestorySingletonImpl implements DestructionAwareBeanPostProcessor {

  @Override
  public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {

  }

  @Override
  public boolean requiresDestruction(Object bean) {
    return false;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    // 销毁处理器
    return null;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return null;
  }
}
