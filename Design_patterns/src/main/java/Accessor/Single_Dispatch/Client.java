package Accessor.Single_Dispatch;

/**
 * Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    oldActor oldActor = new oldActor();
    Role kungFunRole = new KungFunRole();
    // 有歧义.
    // 单分派语言处理一个操作是根据 请求者的名称和接受的参数还决定的
    oldActor.act(kungFunRole);
    oldActor.act(new KungFunRole());
  }

}
