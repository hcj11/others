package AbstractFactory;


/**
 * Created by hcj on 18-7-7
 */
public abstract class AbstractYelloHuman implements Human {

  @Override
  public void getColor() {
    System.out.println("黄种人,的皮肤是黄色的");
  }

  @Override
  public void talk() {
    System.out.println("黄种人说话,说话都是双字节");
  }

}
