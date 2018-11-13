package Response;

/**
 * Created by hcj on 18-7-8
 */
public class Husband extends Handler {

  public Husband() {
    super(Husband_Level);
  }

  @Override
  protected void response(IWomen women) {
    String request = women.getRequest();
    System.out.println(request);
    System.out.println("丈夫不同意");
  }
}
