package com.mshuoke.datagw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Created by hcj on 18-3-7
 */
@EnableAsync  // 加载异步
@SpringBootApplication
public class CerberusApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(CerberusApplication.class);
    app.run(args);
  }

}

