package AbstractFactory;


/**
 * Created by hcj on 18-7-7
 */
public class NvWa {

  public static void main(String[] args) {
    // 抽象生成
    abstractProduce();

  }

  private static void abstractProduce() {
    // produce 黑种男人,黑种女人
    Human blackfemaleHuman = new FemaleFactory().createBlackHuman();
    blackfemaleHuman.getColor();
    blackfemaleHuman.talk();
    blackfemaleHuman.getSex();

    Human maleblackHuman = new MaleFactory().createBlackHuman();
    maleblackHuman.getColor();
    maleblackHuman.talk();
    maleblackHuman.getSex();
  }

}
