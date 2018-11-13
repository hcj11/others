package SpringMvc;

import com.Domain.User;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * Created by hcj on 18-7-20
 */
public class SpringMvc {

  @Test
  public void updateUser(){
    User user = new User();
//    user.setUsername("hah");
    // 对象的封装
    BeanWrapper beanWrapper =
        PropertyAccessorFactory.forBeanPropertyAccess(user);
    beanWrapper.setPropertyValue("username","haha");
    System.out.println(user.getUsername());
    PropertyValue propertyValue = new PropertyValue("username", "hah");
    beanWrapper.setPropertyValue(propertyValue);
    System.out.println(user.getUsername());

  }

  @Test
  public void test(){
    int BATCH_UPDATE_RETURN_VALUE = Integer.MIN_VALUE + 1002;
    System.out.println(BATCH_UPDATE_RETURN_VALUE);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
  }
}
