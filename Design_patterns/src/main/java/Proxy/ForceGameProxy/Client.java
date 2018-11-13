package Proxy.ForceGameProxy;

/**
 * 强制代理, 代理对象必须是  真实对象指定的对象才能调用
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      GamePlayer hhh = new GamePlayer("哈哈哈本人");
      IGamePlayer proxy = hhh.getProxy();
      proxy.login("hcj","123456");
      proxy.killBoss();
      proxy.upgrade();

    }
}
