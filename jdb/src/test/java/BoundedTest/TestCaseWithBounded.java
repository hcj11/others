package BoundedTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Concurrent.Test.BoundedBuffer;
import org.junit.Test;

/**
 * Created by hcj on 18-5-5
 */
public class TestCaseWithBounded {

  @Test
  public void tetsIsEmptyWhenConstructed(){
    BoundedBuffer boundedBuffer = new BoundedBuffer(10);
    assertTrue(boundedBuffer.isEmpty());
    assertFalse(boundedBuffer.isFull());
  }

  @Test
  public void tetsIsFullAfterPut() throws InterruptedException {
    BoundedBuffer boundedBuffer = new BoundedBuffer(10);
    for(int i=0;i<10;i++){
      boundedBuffer.put(i);
    }
    assertFalse(boundedBuffer.isEmpty());
    assertTrue(boundedBuffer.isFull());
  }

}
