package BaseExercise.Demo27;

import java.util.LinkedList;
import java.util.Queue;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-29
 */
@Setter
@Getter
public class Command {

  private String ss = "哈哈哈";

  public String operation() {
    return this.ss;
  }

  class putQueue {

    private Queue<Command> objects = new LinkedList<>();
    private Command command = new Command();

    public putQueue put() {
      objects.add(command);
      return this;
    }
  }

  class getQueue {

    public void get() {
      putQueue put = new putQueue().put();
      Queue<Command> objects = put.objects;
      Command remove = objects.remove();
      System.out.println(remove.operation());
      ;
      System.out.println("剩余： " + objects.size());
    }
  }

  public static void main(String[] args) {
    Command command = new Command();
    command.consume();
  }

  private void consume() {
    getQueue getQueue = new getQueue();
    getQueue.get();
  }

}
