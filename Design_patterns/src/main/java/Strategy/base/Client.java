package Strategy.base;
/**
 * 策略模式
 * Created by hcj on 18-7-8
 */
public class Client {
      public   static  void main(String[] args){
        System.out.println("打开第一个锦囊的时候");
        ZhanYun zhanYun1 = new ZhanYun(new BackDoor());
        zhanYun1.operate();
        System.out.println("打开第二个锦囊的时候");
        ZhanYun zhanYun2 = new ZhanYun(new GivenGreenLight());
        zhanYun2.operate();
        System.out.println("打开第三个锦囊的时候");
        ZhanYun zhanYun3 = new ZhanYun(new BlockEnemy());
        zhanYun3.operate();

      }
}
