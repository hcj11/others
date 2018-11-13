package bean.AwareHello;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by hcj on 18-7-14
 */
public class AwareHello implements BeanNameAware {

  @Override
  public void setBeanName(String name) {
    System.out.println(name);
  }
}
