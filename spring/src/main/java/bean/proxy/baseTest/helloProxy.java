package bean.proxy.baseTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by hcj on 18-7-15
 */
@Aspect
public class helloProxy {

  // 切点
  @Pointcut("execution(* bean.proxy.baseTest.baseTest.hello())")
  public void hello() {
    System.out.println("哈哈");
  }

  // 切面
  @Before("hello()")
  public void before() {
    System.out.println("before");
  }

  // 切面
  @After("hello()")
  public void After() {
    System.out.println("After");
  }

  @AfterReturning("hello()")
  public void AfterReturn() {
    System.out.println("AfterReturn");
  }

  // 切面 环绕通知 之后的方法结束操作
  @Around("hello()")
  public Object aroundTest(ProceedingJoinPoint pjp) {
    System.out.println("before1");
    Object o = null;
    try {
      o = pjp.proceed();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    System.out.println("after1");
    return o;
  }

}
