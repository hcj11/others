package Proxy.baseGameProxy;

import Proxy.jdkProxyExtend.INanny;
import java.time.Instant;

/**
 * Created by hcj on 18-7-7
 */
public class GamePlayerProxy implements IGamePlayer {
  private IGamePlayer player;
  public GamePlayerProxy(){}
  public GamePlayerProxy(IGamePlayer player){
    this.player=player;
  }
  @Override
  public void login(String user, String password) {
    // aop ...
    System.out.println("登录开始时间:" + Instant.now());
    player.login(user,password);
    System.out.println();
    System.out.println("登录结束时间:" + Instant.now());
  }
  @Override
  public void killBoss() {
    player.killBoss();
  }

  @Override
  public void upgrade() {
    player.upgrade();
  }

}
