package Flyweight.extend;

import java.util.HashMap;

/**
 * Created by hcj on 18-7-9
 */
public class SignInfoFactory {

  private SignInfo signInfo;
  private static HashMap<ExtrinsicState, SignInfo> map = new HashMap<ExtrinsicState, SignInfo>();

  public static SignInfo getSignInfo(ExtrinsicState key) {
    // 将考场 location 和科目 subject 存储到map中
    SignInfo signInfo = map.get(key);
    if (signInfo == null) {
//      System.out.println("池子中没有该信息");
      SignInfo4Pool signInfo4Pool = new SignInfo4Pool(key);
      map.put(key, signInfo4Pool);
      return signInfo4Pool;
    } else {
      System.out.println("池子中有该信息: "+key);
      return signInfo;
    }
  }

}
