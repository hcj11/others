package Command;

/**
 * Created by hcj on 18-7-8
 */
public class Invoker {
  private  Command command;
  public void setCommand(Command command){
    this.command=command;
  }
  public void Action(){
    command.execute();
  }
}
