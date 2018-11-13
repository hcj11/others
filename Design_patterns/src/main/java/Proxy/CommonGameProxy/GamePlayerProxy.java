package Proxy.CommonGameProxy;

import java.time.Instant;

/**
 * Created by hcj on 18-7-7
 */
public class GamePlayerProxy implements IGamePlayer {

  private IGamePlayer gamePlayer;

  public GamePlayerProxy() {
  }

  public GamePlayerProxy(String _name) throws Exception {
    // 构建过程交给代理来办, 本人无需干预 ,写死是对谁的代理,
    this.gamePlayer = new GamePlayer(this,_name);
  }

  @Override
  public void login(String user, String password) {
//    // aop ...
    System.out.println("登录开始时间:" + Instant.now());
    this.gamePlayer.login(user, password);
    System.out.println();
    System.out.println("登录结束时间:" + Instant.now());
  }

  @Override
  public void killBoss() {
    this.gamePlayer.killBoss();
  }

  @Override
  public void upgrade() {

    this.gamePlayer.upgrade();
  }
}
