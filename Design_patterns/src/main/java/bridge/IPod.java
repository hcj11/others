package bridge;

/**
 * Created by hcj on 18-7-9
 */
public class IPod extends Product {
  @Override
  public void beProducted() {
    System.out.println("IPod造出来了; ");
  }

  @Override
  public void beSelled() {
    System.out.println("IPod卖出去了; ");
  }
}
