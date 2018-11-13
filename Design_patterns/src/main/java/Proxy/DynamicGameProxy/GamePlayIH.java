package Proxy.DynamicGameProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hcj on 18-7-7
 */
public class GamePlayIH implements InvocationHandler {

  // 被代理者
  Class cls = null;
  // 被代理者的实例
  Object object = null;

  public GamePlayIH(Object object) {
    this.object = object;
  }

  // 接口反射实现动态代理 ,不随真实对象的变化而变化
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if(method.getName().equals("login")){
      String user = String.valueOf(args[0]);
      System.out.println("有人用"+user+"(本人)账号登录了有效");
    }
    Object result = method.invoke(this.object, args);

    return result;
  }


}
