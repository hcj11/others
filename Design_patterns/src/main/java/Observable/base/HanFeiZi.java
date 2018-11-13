package Observable.base;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-8
 */
public class HanFeiZi implements IHanFeiZi, Observable {

  private ArrayList<Observer> observers = new ArrayList<>();

  @Override
  public void haveBreakfast() {

//    System.out.println("HanFeiZi 在吃饭");
    notifyObserver("HanFeiZi 在吃饭");
  }

  @Override
  public void haveFun() {
//    System.out.println();
    notifyObserver("HanFeiZi 在happy");
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void delObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObserver(String context) {
    for (Observer observer : observers) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          observer.update(context);
        }
      }).start();
    }
  }
}
