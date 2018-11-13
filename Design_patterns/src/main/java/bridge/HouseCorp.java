package bridge;

/**
 * 1. 对于继承层数比较多
 * 2. 对于接口或者抽象不确定的情况下
 * Created by hcj on 18-7-9
 */
public class HouseCorp extends Corp {

  public HouseCorp(Product product) {
    super(product);
  }

  public  void makeMoney(){
    super.makeMoney();
    System.out.println("房地产挣钱...");
  }
}
