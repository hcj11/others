package Status;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-9
 */
@Setter
@Getter
public class Context {

  private LiftState liftState;
   // 状态合集
  public static  OpenningState OpenningState = new OpenningState();
  public static  CloseState closeState = new CloseState();
  public static  RunningState runningState = new RunningState();
  public static  StopState stopState = new StopState();

  public void setLiftState(LiftState liftState) {
    this.liftState = liftState;
    // 把当前状态通知到各个环境中
    this.liftState.setContext(this);
  }

  public void open() {
    this.liftState.open();
  }

  public void close() {
    this.liftState.close();
  }


  public void run() {
    this.liftState.run();
  }


  public void stop() {
    this.liftState.stop();
  }


}
