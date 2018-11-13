package Concurrent.commonExecutorService;

import com.google.common.collect.ImmutableMultimap;
import com.sun.btrace.BTraceUtils.Sys;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by hcj on 18-4-7
 */
public class countExecutorService {

  private final ExecutorService executorService = Executors.newSingleThreadExecutor();
  private final long TIMEOUT = 100;
  private final TimeUnit milliseconds = TimeUnit.MILLISECONDS;

  public void start() {
    // 保存立即关闭时,未开始的任务
    List<Runnable> runnables = executorService.shutdownNow();

  }

  public void stop() {
    executorService.shutdown();
    try {
      executorService.awaitTermination(TIMEOUT, milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//      Runtime.getRuntime().addShutdownHook();
//    Runtime.getRuntime().runFinalization();
    // jvm 强行关闭
//    Runtime.getRuntime().halt(0);
    // jvm正常关闭
//    System.exit(0);
  }

  public void count(Runnable runnable) {
    try {
      executorService.submit(runnable);
//      executorService.submit(runnable);
    } catch (RejectedExecutionException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ImmutableMultimap map = new ImmutableMultimap.Builder<Integer, String>()
        .put(1, "编号")
        .put(2, "日期")
        .put(11, "城市")
        .put(12, "批次")
        .put(13, "点击量")
        .put(14, "省")
        .put(15, "生日")
        .put(16, "辅导类型") // study_type
        .build();
    map.put("1","2");

  }
}
