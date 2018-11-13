package Proxy.baseGameExtendProxy;

import java.time.Instant;

/**
 * Created by hcj on 18-7-7
 */
public class GamePlayerProxy implements IGamePlayer, IProxy {

  private IGamePlayer player;
  private int count = 0;

  public GamePlayerProxy() {
  }

  public GamePlayerProxy(IGamePlayer player) {
    this.player = player;
  }

  @Override
  public void login(String user, String password) {
    // aop ...
    System.out.println("登录开始时间:" + Instant.now());
    player.login(user, password);
    System.out.println();
    System.out.println("登录结束时间:" + Instant.now());
  }

  @Override
  public void killBoss() {
    ++count;
    System.out.println("帮你打怪:"+count+"次");
    player.killBoss();
  }

  @Override
  public void upgrade() {
    player.upgrade();
  }

  @Override
  public int count() {
    return count;
  }
}
