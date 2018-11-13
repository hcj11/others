package BuilderDemo;

/**
 * Created by hcj on 18-7-12
 */
public class BMWBuilder extends CarBuilder{

  @Override
  public String buildWheel() {
    return super.getBlueprint().getEngine();
  }

  @Override
  public String buildEngine() {
    return super.getBlueprint().getWheel();
  }
}
