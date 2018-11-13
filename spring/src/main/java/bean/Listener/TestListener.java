package bean.Listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by hcj on 18-7-14
 */
public class TestListener implements ApplicationListener {

  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    TestEvent event1 = (TestEvent) event;
    event1.print();
  }
}
