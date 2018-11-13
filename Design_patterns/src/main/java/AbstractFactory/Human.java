package AbstractFactory;


/**
 * Created by hcj on 18-7-7
 */
public interface Human {
  // 接口就是public,用来实现
  public void getColor();

  public void talk();
  // 获得性别
  public void getSex();
}
