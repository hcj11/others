package Singleton;

// 懒汉单例,
public class LazySingleton {

  private LazySingleton() {
  }
  // static is importance
  private static LazySingleton lazySingleton = null;

  public static synchronized LazySingleton getLazySingleton() {
    if (lazySingleton == null) {
      lazySingleton = new LazySingleton();
    }
    return lazySingleton;
  }
}