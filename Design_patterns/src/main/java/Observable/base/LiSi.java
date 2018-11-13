package Observable.base;


/**
 * Created by hcj on 18-7-8
 */
public class LiSi implements Observer {

  @Override
  public void update(String context) {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("lisi得到的通知是: "+context);
  }
}
