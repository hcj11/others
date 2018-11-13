package bean.Circle;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-14
 */
@Setter
@Getter
public class TestB {
  private TestC testC;
  public TestB(){}
  public TestB(TestC testC) {
    this.testC=testC;
  }

  public void getName(){
    System.out.println(testC.hashCode());
  }

}
