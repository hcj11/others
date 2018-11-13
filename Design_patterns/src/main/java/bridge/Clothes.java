package bridge;

/**
 * Created by hcj on 18-7-9
 */
public class Clothes extends Product {

  @Override
  public void beProducted() {
    System.out.println("Clothes造出来了; ");
  }

  @Override
  public void beSelled() {
    System.out.println("Clothes卖出去了; ");
  }
}
