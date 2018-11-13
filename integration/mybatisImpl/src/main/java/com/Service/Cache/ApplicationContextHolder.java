package com.Service.Cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/** @Configuration
 * Created by hcj on 18-7-28
 */
@Configuration
public class ApplicationContextHolder implements ApplicationContextAware {
  private static ApplicationContext applicationContext;
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    // 获取在初始化完成之后
      ApplicationContextHolder.applicationContext =applicationContext;
  }


  public static Object getBean(String hashUtil) {
    return applicationContext.getBean(hashUtil);
  }
}
