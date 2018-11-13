package Proxy.jdkProxyExtend;

import Proxy.baseGameProxy.GamePlayer;
import Proxy.baseGameProxy.GamePlayerProxy;

/**
 * Created by hcj on 18-7-15
 */
public class Client  {
    public   static  void main(String[] args){
      GamePlayer hhh = new GamePlayer("哈哈哈本人");

      GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(hhh);
      gamePlayerProxy.login("hcj","123456");
      gamePlayerProxy.killBoss();
      gamePlayerProxy.upgrade();

      BuyProxy buyProxy = new BuyProxy(hhh);
      buyProxy.buyThing("玩具枪");

    }
}
