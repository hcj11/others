package com.mshuoke.datagw.controller.utils;

import org.springframework.context.annotation.Configuration;

/**
 * Created by hcj on 18-7-9
 */
@Configuration
public class MockQueue {

  public void addQueue(String result) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          System.out.println("接受订单" + result);
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    }).start();

  }
}
