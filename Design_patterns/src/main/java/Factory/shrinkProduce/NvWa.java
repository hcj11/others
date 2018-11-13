package Factory.shrinkProduce;

/**
 * Created by hcj on 18-7-7
 */
public class NvWa {

  public static void main(String[] args) {
    // 缩小为简单工厂模式
    shrinkProduce();

  }

  private static void shrinkProduce() {
    Human whiteHuman = new HumanFactory().createHuman(WhiteHuman.class);
    whiteHuman.getColor();
    whiteHuman.talk();
    System.out.println("");
    Human yelloHuman = new HumanFactory().createHuman(YelloHuman.class);
    yelloHuman.getColor();
    yelloHuman.talk();
    Human blackHuman = new HumanFactory().createHuman(BlackHuman.class);
    blackHuman.getColor();
    blackHuman.talk();
  }

}
