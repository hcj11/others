package BuilderDemo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-12
 */
@Getter
public abstract class CarBuilder {

  // builder 总领
  private Blueprint blueprint;

  public void receiveBlueprint(Blueprint blueprint) {
    this.blueprint = blueprint;
  }
  public Car buildCar(){
    // 构建车
    return new Car(buildWheel(),buildEngine());
  }

  public abstract String buildWheel() ;

  public abstract String buildEngine() ;

}
