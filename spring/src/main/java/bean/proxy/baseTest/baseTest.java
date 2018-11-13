package bean.proxy.baseTest;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-15
 */
@Setter
@Getter
public class baseTest {

  private String msg = "";

  public void hello() {
    System.out.println("hello "+msg);
  }
}
