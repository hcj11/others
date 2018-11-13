package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 开启 springboot Created by hcj on 18-7-10
 */
@EnableTransactionManagement
@EnableAutoConfiguration
// 需指定扫包位置
@ComponentScan
public class StartUp  {

//  private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//      AppConfig1.class,
//      componentProviderImpl.class);
//  private static UserService userService;
//
//  static {
//    userService = context.getBean(UserService.class);
//  }

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(StartUp.class);
    app.run(args);
  }

}

