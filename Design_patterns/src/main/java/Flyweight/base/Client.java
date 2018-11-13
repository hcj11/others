package Flyweight.base;

import java.util.Random;

/**
 * 享元模式 1. 解决对象过多问题 ,,  对象池原理 Created by hcj on 18-7-9
 */
public class Client {

  public static void main(String[] args) {

    // 构建多个对象
    for (int i = 0; i < 30; i++) {
      Random random = new Random();
      int i1 = random.nextInt(4) + 1;// 1,2,3,4
      String key = "subject: " + i1 + " location: " + i;
      SignInfoFactory.getSignInfo(key);
    }
    SignInfo signInfo = SignInfoFactory.getSignInfo("subject: 1 location: 1");
    // 只存储key信息,其他信息,  单独存储到一个容器中
//        System.out.println(signInfo);

  }
}
