package AbstractFactory;

/**
 * 二维划分,  性别和皮肤
 * Created by hcj on 18-7-7
 */
public class FemaleFactory implements HumanFactory{

  @Override
  public Human createYelloHuman() {
    return null;
  }

  @Override
  public Human createBlackHuman() {
    return new FemaleBlackHuman();
  }

  @Override
  public Human createWhiteHuman() {
    return null;
  }
}
