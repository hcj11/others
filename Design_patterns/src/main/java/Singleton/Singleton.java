package Singleton;

/**
 * 饿汉设计模式 Created by hcj on 18-7-6
 */
public class Singleton {

  // 初始化定义完成 不可变
  private final static Singleton singleton = new Singleton();

  // 私有的构造函数
  private Singleton() {
  }

  public static Singleton getSingleton() {
    return singleton;
  }



}
