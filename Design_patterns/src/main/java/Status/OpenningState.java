package Status;

/**
 * Created by hcj on 18-7-9
 */
public class OpenningState extends LiftState{

  @Override
  public void open() {
      System.out.println("打开电梯后, 开启状态,");
  }

  @Override
  public void close() {
    // 改变当前状态
    super.context.setLiftState(Context.closeState);
    // 动作委派给CloseState 来执行  关闭动作
    super.context.getLiftState().close();
  }

  @Override
  public void run() {
    // do nothing
  }

  @Override
  public void stop() {
    // do nothing
  }
}
