package Proxy.baseGameProxy;

/**
 * 高层模块屏蔽对真实用户的影响 ,使真实对象可以随意更改信息
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      GamePlayer hhh = new GamePlayer("哈哈哈本人");
      GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(hhh);
      gamePlayerProxy.login("hcj","123456");
      gamePlayerProxy.killBoss();
      gamePlayerProxy.upgrade();

    }
}
