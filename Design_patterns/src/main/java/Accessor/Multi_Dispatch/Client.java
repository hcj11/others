package Accessor.Multi_Dispatch;

/**
 * 双分派: 不管演员和角色类怎么变化,  都能找到期望的方法运行.
 * Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    AbsActor oldActor = new oldActor();
    AbsActor youngActor = new YoungActor();
    Role role = new KungFunRole();
    Role idioRole = new IdioRole();

    // 有歧义.
    // 单分派语言处理一个操作是根据 请求者的名称和接受的参数还决定的
      role.accept(oldActor);
      idioRole.accept(oldActor);
//      idioRole.accept(youngActor);
  }

}
