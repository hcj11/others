package Proxy.FullDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 整合 实际类, handler, IAdvice 三者 Created by hcj on 18-7-7
 */
public class FullDynamicProxy<T> {


  public static <T> T newInstance(ClassLoader classLoader, Class<?>[] classes, InvocationHandler handler) {
    new BeforeAdvice().exec();


    return (T) Proxy.newProxyInstance(classLoader, classes, handler);
  }
}
