package Response;

import jdk.internal.org.objectweb.asm.Handle;

/**
 * Created by hcj on 18-7-8
 */
public class Father extends Handler {

  public Father() {
    super(Handler.Father_Level);
  }

  @Override
  protected void response(IWomen women) {
    String request = women.getRequest();
    System.out.println(request);
    System.out.println("父亲不同意");
  }
}
