package Status;

/**
 * Created by hcj on 18-7-9
 */
public class CloseState extends LiftState{

  @Override
  public void open() {
    // 打开电梯门
    super.context.setLiftState(Context.OpenningState);
    super.context.getLiftState().open();
  }

  @Override
  public void close() {
    System.out.println("关闭电梯后, 关闭状态,");
  }

  @Override
  public void run() {
    // 可以运行,
    super.context.setLiftState(Context.runningState);
    super.context.getLiftState().run();
  }

  @Override
  public void stop() {
    // 可以停止,
    super.context.setLiftState(Context.stopState);
    super.context.getLiftState().stop();
  }
}
