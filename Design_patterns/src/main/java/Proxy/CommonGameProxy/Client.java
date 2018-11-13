package Proxy.CommonGameProxy;

/**
 * 普通代理, 用户  不会访问真实角色
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args) throws Exception {
      GamePlayerProxy gamePlayerProxy = new GamePlayerProxy("哈哈哈的游戏代理");
      gamePlayerProxy.login("hcj","123456");
      gamePlayerProxy.killBoss();
      gamePlayerProxy.upgrade();

    }
}
