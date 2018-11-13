package Command.Demo;

/**
 * Created by hcj on 18-7-12
 */
public class Invoker {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void action() {
    command.exec();
  }
}
