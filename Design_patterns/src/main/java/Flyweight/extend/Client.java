package Flyweight.extend;

import java.util.Random;

/**
 * 享元模式 测试性能, 采用java 基本类型或者 对象类型
 *
 * Created by hcj on 18-7-9
 */
public class Client {

  public static void main(String[] args) {

    // 构建多个对象
    for (int i = 0; i < 30; i++) {
      Random random = new Random();
      int i1 = random.nextInt(4) + 1;// 1,2,3,4
      ExtrinsicState extrinsicState = new ExtrinsicState();
      extrinsicState.setLocation(i1 + "");
      extrinsicState.setSubject(i + "");
//      String key = "subject: " + i1 + " location: " + i;
      SignInfoFactory.getSignInfo(extrinsicState);
    }
    ExtrinsicState extrinsicState = new ExtrinsicState();
    extrinsicState.setLocation("1");
    extrinsicState.setSubject("1");
    SignInfo signInfo = SignInfoFactory.getSignInfo(extrinsicState);
    // 只存储key信息,其他信息,  单独存储到一个容器中
//        System.out.println(signInfo);

  }
}
