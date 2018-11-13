package bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hcj on 18-7-14
 */
@Configuration
public class Config {
  // 构造函数的依赖

  @Bean
  public Student student(){
    // 构造函数传递参数, 或者set传递参数, 相同的对象也是如此
    return new Student("1");
  }
}
