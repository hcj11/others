package Proxy.FullDynamicProxy;

/**
 * Created by hcj on 18-7-7
 */
public class RealSubject implements Subject {

  @Override
  public void doSomething() {
      System.out.println("do something");
  }
}
