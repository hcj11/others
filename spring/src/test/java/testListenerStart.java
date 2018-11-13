import bean.Listener.TestEvent;
import bean.extend.MyClassPathXmlApplication;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hcj on 18-7-14
 */
public class testListenerStart {

  @Test
  public void listener(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "applicationContext.xml");

    TestEvent event = new TestEvent("hcj","哈哈哈");
    // 发送事件,,
    classPathXmlApplicationContext.publishEvent(event);
  }
}
