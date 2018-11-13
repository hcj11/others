package possibleRecordering;

import org.junit.Test;

/**
 * Created by hcj on 18-5-24
 */
public class possibleRecordering {

  private int x = 0, y = 0, a = 0, b = 0;

  @Test
  public void test() throws InterruptedException {
    for(int i=0;;i++){
      Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
          a = 1;
          x = b;  // a=1 x=0
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });

      Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
          b = 1;
          y = a; // b=1,y=1
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });

      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
      if(x!=0 && y!=1){

        System.out.println("x= "+x + ",y= "+y);
      }
      x=0;y=0;a=0;b=0;
    }


  }

}
