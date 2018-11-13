package Factory.firstProduce;


/**
 * Created by hcj on 18-7-7
 */
public class NvWa {

  public static void main(String[] args) {
    // 正常向工厂类
    firstProduce();
    // 缩小为简单工厂模式
    shrinkProduce();

  }

  private static void shrinkProduce() {

  }

  private static void firstProduce() {
      // 创建一个白人
   // 用接口去接 ,解耦实现类
    Human whiteHuman = new HumanFactory().createHuman(WhiteHuman.class);
    whiteHuman.getColor();
    whiteHuman.talk();
    Human yelloHuman = new HumanFactory().createHuman(YelloHuman.class);
    yelloHuman.getColor();
    yelloHuman.talk();
    Human blackHuman = new HumanFactory().createHuman(BlackHuman.class);
    blackHuman.getColor();
    blackHuman.talk();
  }
}
