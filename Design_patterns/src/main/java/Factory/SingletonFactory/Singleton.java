package Factory.SingletonFactory;

/**
 * Created by hcj on 18-7-7
 */
public class Singleton {
  private Singleton(){}
  private int count=0;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void doSomething(){

    System.out.println(" do something ...");

  }
}
