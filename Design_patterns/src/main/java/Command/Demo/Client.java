package Command.Demo;

/**
 * Created by hcj on 18-7-12
 */
public class Client {
    public   static  void main(String[] args){
      // 将命令和操作进行解耦 对于invoke的执行
      Invoker invoker = new Invoker();
      invoker.setCommand(new MyCommand());
      invoker.action();
    }
}
