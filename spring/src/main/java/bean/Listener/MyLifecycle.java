package bean.Listener;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.Lifecycle;

/**
 * Created by hcj on 18-7-15
 */
public class MyLifecycle implements Lifecycle {

  private volatile ConfigurableListableBeanFactory beanFactory;

  // 开始轮询
  @Override
  public void start() {
       beanFactory.destroySingletons();
      System.out.println("开始监控mq");
  }

  @Override
  public void stop() {
    System.out.println("spring 停止,断开和mq的轮询等");
  }

  @Override
  public boolean isRunning() {
    return true;
  }
}
