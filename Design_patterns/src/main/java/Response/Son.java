package Response;

/**
 * Created by hcj on 18-7-8
 */
public class Son extends Handler {

  public Son() {
    super(Son_Level);
  }

  @Override
  protected void response(IWomen women) {
    String request = women.getRequest();
    System.out.println(request);
    System.out.println("儿子同意了,");
  }
}
