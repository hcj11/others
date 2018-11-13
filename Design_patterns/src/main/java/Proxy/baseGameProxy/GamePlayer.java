package Proxy.baseGameProxy;

import Proxy.jdkProxyExtend.INanny;

/**
 * Created by hcj on 18-7-7
 */
public class GamePlayer implements IGamePlayer ,INanny{

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

  @Override
  public void buyThing(String somthing) {
    System.out.println(this.name + "   在购物 ...");
  }
}
