package Proxy.FullDynamicProxy;

/**
 * Created by hcj on 18-7-7
 */
public class BeforeAdvice implements IAdvice {

  @Override
  public void exec() {
    System.out.println("实际操作的准备工作....");
  }
}
