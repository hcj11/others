package Proxy.ForceGameProxy;

/**
 * Created by hcj on 18-7-7
 */
public class GamePlayer implements IGamePlayer {

  private String name;
  private IGamePlayer proxy = null;

  public GamePlayer() {
  }

  public GamePlayer(String _name) {
    this.name = _name;
  }

  @Override
  public void login(String user, String password) {
    // force use proxy
    if(this.proxy!=null){
      System.out.println(this.name + "   在登录 ..." + user + ":" + password);
    }else{
      System.out.println("请使用代理登录,  本人没空");
    }

  }

  @Override
  public void killBoss() {
    if(this.proxy!=null){
      System.out.println(this.name + "   在杀怪 ...");
    }else{
      System.out.println("请使用代理杀怪,  本人没空");
    }

  }

  @Override
  public void upgrade() {
    if(this.proxy!=null){
      System.out.println(this.name + "   在升级 ...");
    }else{
      System.out.println("请使用代理升级,  本人没空");
    }

  }

  @Override
  public IGamePlayer getProxy() {
    // 返回我的代理人 ,自己找到代理,无需new代理
    GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(this);
    this.proxy = gamePlayerProxy;
    return gamePlayerProxy;

  }
}
