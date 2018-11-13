package Factory.multiFactoryProduce;


/**
 * Created by hcj on 18-7-7
 */
public class BlackHuman  implements Human {

  @Override
  public void getColor() {
    System.out.println("黑种人,的皮肤是黑色的");
  }

  @Override
  public void talk() {
    System.out.println("黑种人说话,有点听不懂");
  }
}
