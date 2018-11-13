package Proxy.DynamicGameProxy;

import java.lang.reflect.Method;

/**
 * Created by hcj on 18-7-7
 */
public class GamePlayer implements IGamePlayer {

  private String name;

  public GamePlayer() {
  }

  public GamePlayer(String _name) {
    this.name = _name;
  }

  @Override
  public void login(String user, String password) {
    System.out.println(this.name + "   在登录 ..."+user+":"+password);

  }

  @Override
  public void killBoss() {
    System.out.println(this.name + "   在杀怪 ...");
  }

  @Override
  public void upgrade() {
    System.out.println(this.name + "   在升级 ...");
  }
}
