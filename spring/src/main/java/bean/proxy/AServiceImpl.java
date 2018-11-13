package bean.proxy;


import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注解上下文测试.
 *  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

 * Created by hcj on 18-7-15
 */
public class AServiceImpl implements AService {
  @Transactional(propagation = Propagation.REQUIRED)
  public void a() {
//    this.b();
    // 添加事务增强
    ((AService)AopContext.currentProxy()).b();
  }
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void b() {

  }
}
