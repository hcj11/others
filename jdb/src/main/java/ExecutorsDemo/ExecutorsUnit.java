package ExecutorsDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hcj on 18-7-28
 */
public class ExecutorsUnit extends ThreadPoolExecutor {

  public ExecutorsUnit(int corePoolSize, int maximumPoolSize, long keepAliveTime,
      TimeUnit unit,
      BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  @Override
  protected void afterExecute(Runnable r, Throwable t) {
    super.afterExecute(r, t);
  }

  @Override
  protected void beforeExecute(Thread t, Runnable r) {
    super.beforeExecute(t, r);
  }

  @Override
  public void shutdown() {
    super.shutdown();
  }
}
