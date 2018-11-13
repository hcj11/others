package Command;
/**
 * Created by hcj on 18-7-8
 */
public class Client  {
    public   static  void main(String[] args){
      // invoker 直接下命令
      Invoker invoker = new Invoker();
      DelPageCommand delPageCommand = new DelPageCommand();

      invoker.setCommand(delPageCommand);
      invoker.Action();
    }
}
