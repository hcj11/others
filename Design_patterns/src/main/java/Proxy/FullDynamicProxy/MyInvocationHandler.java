package Proxy.FullDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hcj on 18-7-7
 */
public class MyInvocationHandler implements InvocationHandler {

  private Object object = null;

  public MyInvocationHandler(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 无泛型 (RealSubject)
    return   method.invoke(object, args);
  }
}
