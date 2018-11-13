package Singleton;

/**
 * Created by hcj on 18-7-6
 */
public class Client {

  public static void main(String[] args) {
    // 私有无法访问
//      Singleton singleton = new Singleton();
//      Singleton singleton1 = Singleton.getSingleton();
//      Singleton singleton2 = Singleton.getSingleton();
//      System.out.println(singleton1==singleton2);
//      LazySingleton lazySingleton1 = LazySingleton.getLazySingleton();
//      LazySingleton lazySingleton2 = LazySingleton.getLazySingleton();
//      System.out.println(lazySingleton1==lazySingleton2);
    //

    new Client().MaxEmperorTest();

  }

  private void MaxEmperorTest() {
    for (int i = 0; i < 5; i++) {
      Emperor instance = Emperor.getInstance();
      System.out.print("第" + i + "位达成参见:");
      // 不推荐
      instance.say();
      // 换行.
      System.out.println();
    }

  }


}
