package Proxy.FullDynamicProxy;

/**
 * Created by hcj on 18-7-7
 */
public class SubjectDynamicProxy extends FullDynamicProxy {

  public static <T> T newInstance(Subject subject) {
    // 对实际的某一个实现类的代理操作
    ClassLoader classLoader = subject.getClass().getClassLoader();
    Class<?>[] interfaces = subject.getClass().getInterfaces();
    MyInvocationHandler myInvocationHandler = new MyInvocationHandler(subject);

    return newInstance(classLoader, interfaces, myInvocationHandler);
  }

}
