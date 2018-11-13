package Builder.baseWithDirectorBuilder;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-7
 */
public abstract class CarModel {

  private ArrayList<String> sequence = new ArrayList<String>();

  protected abstract void start();

  protected abstract void stop();

  protected abstract void alarm();

  protected abstract void engineBoom();

  // 模板方法 , 不允许重写
  public final void run() {
    // 根据传来的顺序来确定执行的顺序
    for (String type : this.sequence) {
      switch (type) {
        case "start":
          this.start();
          break;
        case "stop":
          this.stop();
          break;
        case "alarm":
          if (this.isAlarm()) { // 子类的变量,信息
            this.alarm();
          }
          break;
        default:
          this.engineBoom();
          break;
      }
    }

  }

  final public void setSequence(ArrayList<String> sequence) {
    // 根据顺序排列 , 由子类实现
    this.sequence = sequence;
  }

  // 判断是否执行 alarm这个命令 默认是喇叭是会响的,  钩子方法
  // 由子类进行重写,实现, 否则使用父类的方法
  protected boolean isAlarm() {
    return true;
  }
}
