package Proxy.baseGameExtendProxy;

/**
 * 扩展代理接口, 提供代理服务的收费标准
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      GamePlayer hhh = new GamePlayer("哈哈哈本人");
      GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(hhh);
      gamePlayerProxy.login("hcj","123456");
      gamePlayerProxy.killBoss();
      gamePlayerProxy.upgrade();
      gamePlayerProxy.killBoss();
      int i = gamePlayerProxy.count() * 50;
      System.out.println("总消费: "+i);

    }
}
