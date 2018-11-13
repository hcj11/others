package bean.AwareHello;

import bean.Student;
import java.io.IOException;
import java.net.URL;
import org.springframework.beans.factory.BeanClassLoaderAware;

/**
 * Created by hcj on 18-7-14
 */
public class AwareHelloBeanClassLoader implements BeanClassLoaderAware {

  @Override
  public void setBeanClassLoader(ClassLoader classLoader) {
//    try {
//      classLoader.loadClass(Student.class.getName());
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
//    }
//    URL resource = classLoader.getResource("classpath:testBean.xml");
//    try {
//      System.out.println(resource.getContent());;
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
