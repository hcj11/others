package Proxy.DynamicGameProxy;

import java.lang.reflect.Proxy;

/**
 * 高层模块屏蔽对真实用户的影响 ,使真实对象可以随意更改信息 Created by hcj on 18-7-7
 */
public class Client {

  public static void main(String[] args) {
    IGamePlayer hcj = new GamePlayer("哈哈哈本人");
    GamePlayIH handler = new GamePlayIH(hcj);
    ClassLoader classLoader = hcj.getClass().getClassLoader();
    IGamePlayer proxy = (IGamePlayer) Proxy
        .newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, handler);
    proxy.login("hcj", "1234556");
    proxy.killBoss();
    proxy.upgrade();


  }
}
