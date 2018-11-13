package AbstractFactory;


/**
 * Created by hcj on 18-7-7
 */
public abstract class AbstractWhiteHuman implements Human {

  @Override
  public void getColor() {
    System.out.println("白种人,的皮肤是白色的");
  }

  @Override
  public void talk() {
    System.out.println("白种人说话,说话都是单字节");
  }
  public abstract void getSex();

}
