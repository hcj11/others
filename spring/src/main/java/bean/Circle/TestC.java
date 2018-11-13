package bean.Circle;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-14
 */
@Setter
@Getter
public class TestC {
  private TestA testA;

  public TestC(TestA testA) {
    this.testA=testA;
  }

  public TestC() {
  }

  public void getName(){
    System.out.println(testA.hashCode());
  }
}
