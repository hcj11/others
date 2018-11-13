package com.Config;

import com.Domain.User;
import com.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * Created by hcj on 18-7-21
 */
@Component
public class MyLifeCycle implements SmartLifecycle {

  @Autowired
  UserService userService;

  @Override
  public void start() {
    System.out.println("容器启动");
    // 开启轮询线程,轮询数据正确性.
  }

  @Override
  public void stop() {
    System.out.println("容器关闭");
  }

  @Override
  public boolean isRunning() {
    return false;
  }

  @Override
  public boolean isAutoStartup() {
    return true;
  }

  @Override
  public void stop(Runnable callback) {
    System.out.println("***************异步回调");
    callback.run();
  }

  @Override
  public int getPhase() {
    return 0;
  }
}
