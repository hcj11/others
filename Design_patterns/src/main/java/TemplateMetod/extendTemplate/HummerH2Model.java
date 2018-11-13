package TemplateMetod.extendTemplate;

/**
 * Created by hcj on 28-7-7
 */
public class HummerH2Model extends HummerModel {

  @Override
  public void start() {
    System.out.println(" 悍马H2 start...");
  }

  @Override
  public void stop() {
    System.out.println(" 悍马H2 stop...");
  }

  @Override
  public void alarm() {
    System.out.println(" 悍马H2 alarm...");
  }

  @Override
  public void engineBoom() {
    System.out.println(" 悍马H2 engineBoom...");
  }

  @Override
  protected boolean isAlarm() {
    // 反正他就不响 ,不管他了
    return false;
  }
}
