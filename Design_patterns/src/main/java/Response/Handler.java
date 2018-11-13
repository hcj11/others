package Response;

/**
 * Created by hcj on 18-7-8
 */
public abstract class Handler {

  protected final static int Father_Level = 1;
  protected final static int Husband_Level = 2;
  protected final static int Son_Level = 3;
  protected int count =0;
  private int level = 0;
  private Handler nextHandler;

  // 必须提供一个等级
  public Handler(int level) {
    //
    ++count;
    if (count>3){
      System.out.println("数量超过3个了,影响正常的测试了 ");
    }
    this.level = level;
  }

  // 女人处理器
  public final void HandlerMessage(IWomen women) {
    // 递归链
    int type = women.getType();
    if (type == this.level) {
      this.response(women);

    } else {
      if (this.nextHandler != null) {
        this.nextHandler.HandlerMessage(women);
      } else {
        System.out.println("没有地方可以请示了, 按照不同意处理----\n");
      }

    }
  }

  public void setNext(Handler handler) {
    this.nextHandler = handler;
  }

  protected abstract void response(IWomen women);
}
