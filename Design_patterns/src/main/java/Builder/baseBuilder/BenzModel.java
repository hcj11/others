package Builder.baseBuilder;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-7
 */
public class BenzModel extends CarModel {

  private ArrayList<String> list = new ArrayList<String>();

  @Override
  public void start() {
    System.out.println(" Benz start...");
  }

  @Override
  public void stop() {
    System.out.println(" Benz stop...");
  }

  @Override
  public void alarm() {
    System.out.println(" Benz alarm...");
  }

  @Override
  public void engineBoom() {
    System.out.println(" Benz engineBoom...");
  }


}
