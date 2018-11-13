package Accessor.Multi_Dispatch;

/**
 * Created by hcj on 18-7-8
 */
public class IdioRole implements Role {
  @Override
  public void accept(AbsActor absActor) {
    absActor.act(this);
  }
}
