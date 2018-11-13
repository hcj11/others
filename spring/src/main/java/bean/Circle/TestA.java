package bean.Circle;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-14
 */
@Setter
@Getter
public class TestA {

  private TestB testB;

  public TestA() {
  }

  public TestA(TestB testB) {
    this.testB = testB;
  }

  public void getName() {
    System.out.println(testB.hashCode());
  }

}
