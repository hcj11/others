package Proxy.jdkProxyExtend;

/**
 * Created by hcj on 18-7-15
 */
public class BuyProxy implements INanny{
  private INanny iNanny;
  public BuyProxy(INanny iNanny){
    this.iNanny=iNanny;
  }

  @Override
  public void buyThing(String somthing) {
    // 代理某人
//    System.out.println("代理某人购物");
    iNanny.buyThing(somthing);
  }
}
