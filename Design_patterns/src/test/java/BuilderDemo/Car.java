package BuilderDemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-12
 */
public class Car  implements ICar{
  public Car(){}
  public Car(String sheel,String Engine){
    this.sheel=sheel;
    this.Engine=Engine;
  }
  private String sheel;
  private String Engine;

  public String toString() {
    return "车轮: " +this.getSheel() +" ,零件: "+this.getEngine();
  }

  @Override
  public String getSheel() {
      return this.sheel;
  }

  @Override
  public String getEngine() {
    return this.Engine;
  }
}
