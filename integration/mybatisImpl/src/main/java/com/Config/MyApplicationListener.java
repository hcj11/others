package com.Config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * Created by hcj on 18-7-20
 */
@Component
public class MyApplicationListener  implements ApplicationListener<ContextRefreshedEvent>{
  // 但是只执行了一次?
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
//    Object bean = event.getApplicationContext().getBean("");
//    // 做bean 的监听.
    System.out.println(" ContextRefreshedEvent 的时间:  "+event.getTimestamp());

  }
}
