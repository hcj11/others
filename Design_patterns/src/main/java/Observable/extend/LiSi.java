package Observable.extend;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by hcj on 18-7-8
 */
public class LiSi implements Observer {

  @Override
  public void update(Observable o, Object arg) {

//    try {
//      Thread.sleep(100);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
      System.out.println(o);
    System.out.println("lisi得到的通知是: "+ (String) arg);
  }
}
