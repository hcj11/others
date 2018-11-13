package Builder.baseWithDirectorBuilder;


import Builder.baseBuilder.Builder;

/**
 * Created by hcj on 18-7-7
 */
public class BMWModel extends CarModel {

  private boolean isAlarm = false;

  @Override
  public void start() {
    System.out.println(" BMW start...");
  }

  @Override
  public void stop() {
    System.out.println(" BMW stop...");
  }

  @Override
  public void alarm() {
    System.out.println(" BMW alarm...");
  }

  @Override
  public void engineBoom() {
    System.out.println(" BMW engineBoom...");
  }

  public void setAlarm(boolean alarm) {
    isAlarm = alarm;
  }

  // 判断是否响
  @Override
  protected boolean isAlarm() {
    return isAlarm;
  }

}
