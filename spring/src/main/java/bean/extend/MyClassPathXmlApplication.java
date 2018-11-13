package bean.extend;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 扩展bean
 * Created by hcj on 18-7-14
 */
public class MyClassPathXmlApplication extends ClassPathXmlApplicationContext{
    public MyClassPathXmlApplication(String... config){
      super(config);
    }

  @Override
  protected void initPropertySources() {
//    getEnvironment().setRequiredProperties("VAR");
  }
}
