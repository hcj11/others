package TemplateMetod.extendTemplate;

/**
 * Created by hcj on 18-7-7
 */
public class HummerH1Model extends HummerModel {

  private boolean isAlarm = false;

  @Override
  public void start() {
    System.out.println(" 悍马H1 start...");
  }

  @Override
  public void stop() {
    System.out.println(" 悍马H1 stop...");
  }

  @Override
  public void alarm() {
    System.out.println(" 悍马H1 alarm...");
  }

  @Override
  public void engineBoom() {
    System.out.println(" 悍马H1 engineBoom...");
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
