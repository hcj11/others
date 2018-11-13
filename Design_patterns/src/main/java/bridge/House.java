package bridge;

/**
 * Created by hcj on 18-7-9
 */
public class House extends Product {

  @Override
  public void beProducted() {
    System.out.println("房子造出来了; ");
  }

  @Override
  public void beSelled() {
    System.out.println("房子卖出去了; ");
  }
}
