package bridge;

/**
 * Created by hcj on 18-7-9
 */
public class ShanZhaiCorp extends Corp {

  public ShanZhaiCorp(Product product) {
    super(product);
  }

  public  void makeMoney(){
    super.makeMoney();
    System.out.println("山寨挣钱...");
  }
}
