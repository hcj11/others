package TemplateMetod.extendTemplate;

/**
 * Created by hcj on 18-7-7
 */
public abstract class HummerModel {

  protected abstract void start();

  protected abstract void stop();

  protected abstract void alarm();

  protected abstract void engineBoom();

  // 模板方法 , 不允许重写
  public final void run() {
    // 四个动作不变
    this.start();
    if (this.isAlarm()) { // 子类的变量,信息
      this.alarm();
    }
    // 发动引擎
    this.engineBoom();
    this.stop();
  }

  // 判断是否执行 alarm这个命令 默认是喇叭是会响的,  钩子方法
  // 由子类进行重写,实现  ,或者final 禁止重写操作
  protected  boolean isAlarm(){
    return true;
  }


}
