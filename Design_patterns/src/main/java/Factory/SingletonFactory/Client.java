package Factory.SingletonFactory;

/**
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      Singleton singleton1 = SingletonFactory.getSingleton();

      Singleton singleton2 = SingletonFactory.getSingleton();
      System.out.println(singleton1==singleton2);
      int count = singleton1.getCount();
      singleton1.setCount(++count);
      // 同一个对象
      System.out.println(singleton1.getCount());

      System.out.println(singleton2.getCount());

//      singleton1.doSomething();;

    }
}
