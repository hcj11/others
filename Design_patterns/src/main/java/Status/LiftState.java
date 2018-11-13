package Status;

/**
 * Created by hcj on 18-7-9
 */
public abstract class LiftState {

  protected Context context;

  public void setContext(Context context) {
    this.context = context;
  }

  public abstract void open();

  public abstract void close();

  public abstract void run();

  public abstract void stop();
}
