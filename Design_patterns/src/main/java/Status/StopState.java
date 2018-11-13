package Status;

/**
 * Created by hcj on 18-7-9
 */
public class StopState extends LiftState{

  @Override
  public void open() {
    // 可以打开门
    super.context.setLiftState(Context.OpenningState);
    super.context.getLiftState().open();
  }

  @Override
  public void close() {
    // do nothing
   //  System.out.println("关闭电梯后, 关闭状态, 就是关闭");
//    super.context.setLiftState(Context.closeState);
//    super.context.getLiftState().close();
  }

  @Override
  public void run() {
    // 继续运行
    super.context.setLiftState(Context.runningState);
    super.context.getLiftState().run();
  }

  @Override
  public void stop() {
    System.out.println("stop status 下的关闭状态");
  }
}
