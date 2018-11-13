package Concurrent.ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hcj on 18-7-18
 */
public class Client {

  private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

  public static void main(String[] args) {

    test();
  }

  private static void test() {
    CustomCache<String> objectCustomCache = new CustomCache<>();
    // decorator
    ReentrantCache<String> stringReentrantCache = new ReentrantCache<>(objectCustomCache);
//    stringReentrantCache.setTimeout(111);
    //
    stringReentrantCache.getObject("112");
    stringReentrantCache.putObject("112", "001");

    for (int i = 0; i < 10; i++) {
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          // 第一次未获取到,等到下面几次即可获取了. 全程是线程安全的
          // 或者 try catch 住异常并返回
//            getObject();
          System.out.println(stringReentrantCache.getObject("112"));;

//          stringReentrantCache.putObject("112", "001");
        }

//        private synchronized void getObject() {
//
//          System.out.println(stringReentrantCache.getObject("112"));;
//          try {
//            Thread.sleep(10000);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//
//        }
      });
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    stringReentrantCache.putObject("112", "001");

    String object = stringReentrantCache.getObject("112");
    System.out.println(object);

    try {
          executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
          executorService.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // milis
//    stringReentrantCache.setTimeout(111);
    // 缓存 -> 先获取缓存 并做获取锁的标记,  当释放锁之后才不会出现nop
//    stringReentrantCache.getObject("112");
//    stringReentrantCache.getObject("113");
    // 缓存住之前不存在的值, 然后当有提供之后,存入到缓存中等待
//    stringReentrantCache.putObject("113","001");
//    System.out.println(stringReentrantCache.getObject("112"));

//
//    System.out.println(stringReentrantCache.getSize());

  }
}
