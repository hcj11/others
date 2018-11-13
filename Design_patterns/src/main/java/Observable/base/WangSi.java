package Observable.base;

/**
 * Created by hcj on 18-7-8
 */
public class WangSi implements Observer {

  @Override
  public void update(String context) {
    System.out.println("Wangsi得到的通知是: "+context);
  }
}
