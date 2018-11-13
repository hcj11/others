package Status;

/**
 * Created by hcj on 18-7-9
 */
public class RunningState extends LiftState{

  @Override
  public void open() {
    //do nothing
  }

  @Override
  public void close() {
    // do nothing   run status is close
//    System.out.println("运行时,当然是关闭状态  关闭电梯后, 关闭状态,");
  }

  @Override
  public void run() {
    System.out.println("运行状态要实现的动作");
  }

  @Override
  public void stop() {
    super.context.setLiftState(Context.stopState);
    super.context.getLiftState().stop();
  }
}
