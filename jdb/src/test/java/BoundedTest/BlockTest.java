package BoundedTest;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.fail;

import Concurrent.Test.BoundedBuffer;
import org.junit.Test;

/**
 * 阻塞操作的响应性测试 Created by hcj on 18-5-5
 */
public class BlockTest {

  @Test
  public void testBlocksWhenEmpty() {
    int LOCKUP_DETECT_TIMEOUT = 20000;
    // 并发情况下的测试
    final BoundedBuffer<Integer> boundedBuffer = new BoundedBuffer<Integer>(10);
    Thread taker = new Thread() {
      // 匿名类
      @Override
      public void run() {
        try {
          Integer take = boundedBuffer.take();
          fail(); // 出现错误， 阻塞失败

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    try {
      taker.start();
      Thread.sleep(LOCKUP_DETECT_TIMEOUT);
      taker.interrupt(); // 响应中断
      // 线程回收
      taker.join(LOCKUP_DETECT_TIMEOUT);

      assertFalse(taker.isAlive());
    } catch (InterruptedException e) {
      fail();
    }


  }
}
