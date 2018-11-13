package TemplateMetod.baseTemplate;

/**
 * Created by hcj on 18-7-7
 */
public abstract class HummerModel {
  public abstract void start();
  public abstract void stop();
  public abstract void alarm();
  public abstract void engineBoom();
  // 模板方法 , 不允许重写
  public final void run(){
    // 四个动作不变
    this.start();
    this.alarm();
    // 发动引擎
    this.engineBoom();
    this.stop();
  }


}
