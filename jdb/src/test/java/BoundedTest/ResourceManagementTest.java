package BoundedTest;

import Concurrent.Test.BoundedBuffer;
import org.junit.Test;

/**
 * 方法执行前后的资源测试对比 Created by hcj on 18-5-6
 */
public class ResourceManagementTest {

  class Big {

    int[] data = new int[10000];
  }

  // 资源泄露
  @Test
  public void testLeak() throws InterruptedException {
    BoundedBuffer boundedBuffer = new BoundedBuffer(10);
    // 生成一次堆快照
//    int heapSize = ;
    for (int i = 0; i < 10; i++) {

      boundedBuffer.put(new Big());
    }

    for (int i = 0; i < 10; i++) {
      boundedBuffer.take();
    }
    // 生成一次堆快照
//    int heapSize=;

  }
}
