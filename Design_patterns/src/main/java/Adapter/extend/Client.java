package Adapter.extend;


/**
 * 适配器的扩展 ,有多个要适配的接口
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      // 获取本公司的信息
      IUserInfo userInfo = new UserInfo();
      System.out.println(userInfo.getHomeAddress());
      // 获取它公司的信息
      OuterUserInfo outerUserInfo = new OuterUserInfo();
      System.out.println(outerUserInfo.getHomeAddress());

    }
}
