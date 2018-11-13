package Observable.extend;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by hcj on 18-7-8
 */
public class WangSi implements Observer {

  @Override
  public void update(Observable o, Object arg) {
      System.out.println(o);
      System.out.println("Wangsi得到的通知是: "+(String) arg);
  }
}
