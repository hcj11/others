package Factory.multiFactoryProduce;

/**
 * 直接工厂.,因为只有一个生产产品的情形 ,无需抽象 Created by hcj on 18-7-7
 */
public class WhiteHumanFactory extends AbstractHumanFactory{

  public Human createHuman() {
    // 根据类进行加载创建对象 ,用父类强转?
    return new WhiteHuman();
  }
}
