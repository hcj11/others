package Observable.base;

/**
 * 被观察者
 * Created by hcj on 18-7-8
 */
public interface Observable {
  public void  addObserver(Observer observer);
  public void  delObserver(Observer observer);
  // 通知观察者
  public void  notifyObserver(String context);
}
