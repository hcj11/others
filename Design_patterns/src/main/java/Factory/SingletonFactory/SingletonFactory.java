package Factory.SingletonFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例工厂 Created by hcj on 18-7-7
 */
public class SingletonFactory {

  private static Singleton singleton = null;

  public static synchronized Singleton getSingleton() {
    // 构建实例 ,懒汉单例 ,饿汉
    if (singleton == null) {
      // 反射?
      try {
        Constructor<?> declaredConstructor = Class.forName(Singleton.class.getName())
            .getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        singleton = (Singleton) declaredConstructor.newInstance();

      } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
    }
    return singleton;
  }
}
