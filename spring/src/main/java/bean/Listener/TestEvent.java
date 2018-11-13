package bean.Listener;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件 Created by hcj on 18-7-14
 */
//
@Setter
@Getter
public class TestEvent extends ApplicationEvent {

  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  private String msg;

  public TestEvent(Object source, String msg) {
    super(source);
    this.msg = msg;
  }

  public void print() {
    System.out.println("hello listener!!!"+this.msg);
  }


}
