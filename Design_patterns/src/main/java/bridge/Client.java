package bridge;

/**
 * 桥梁模式 1. 产品和工厂 调用分离 工厂赚钱即可,并不管是什么产品 比较简单的模式, 可以使抽象和实现解耦, 使两种独立的变化
 *
 * Created by hcj on 18-7-9
 */
public class Client {

  public static void main(String[] args) {

    HouseCorp houseCorp = new HouseCorp(new House());
    houseCorp.makeMoney();
    ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
    shanZhaiCorp.makeMoney();
    ShanZhaiCorp shanZhaiCorpForClothes = new ShanZhaiCorp(new Clothes());
    shanZhaiCorpForClothes.makeMoney();

  }
}
