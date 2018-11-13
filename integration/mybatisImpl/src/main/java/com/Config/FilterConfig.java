package com.Config;

import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by hcj on 18-7-20
 */
@Configuration
public class FilterConfig {
  @Bean
  public FilterRegistrationBean someFilterRegistration() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(sessionFilter());
    registration.addUrlPatterns("/*");
    registration.addInitParameter("paramName", "paramValue");
    registration.setName("sessionFilter");
    return registration;
  }

  /**
   * 创建一个bean
   * @return
   */
  @Bean(name = "sessionFilter")
  public Filter sessionFilter() {
    return new MyFilterChain();
  }
}
