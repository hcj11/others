package AbstractFactory;

/**
 * 人工厂
 * Created by hcj on 18-7-7
 */
public abstract class AbstractBlackHuman implements Human{
  //根据人种可以确定,可以完成的部分行为 ,相似的可以继续进行扩展 ,但是会变动难以维护
  @Override
  public void getColor() {
    System.out.println("黑种人,的皮肤是黑色的");
  }

  @Override
  public void talk() {
    System.out.println("黑种人说话,有点听不懂");
  }
  public abstract void getSex();

}
