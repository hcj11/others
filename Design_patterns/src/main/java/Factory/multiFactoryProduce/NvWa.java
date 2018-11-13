package Factory.multiFactoryProduce;

/**
 * Created by hcj on 18-7-7
 */
public class NvWa {

  public static void main(String[] args) {
    // 多工厂类进行单独创建
    multiProduce();

  }

  private static void multiProduce() {
    Human whiteHuman = new BlackHumanFactory().createHuman();
    whiteHuman.getColor();
    whiteHuman.talk();
    Human yelloHuman = new YelloHumanFactory().createHuman();
    yelloHuman.getColor();
    yelloHuman.talk();
    Human blackHuman = new BlackHumanFactory().createHuman();
    blackHuman.getColor();
    blackHuman.talk();
  }

}
