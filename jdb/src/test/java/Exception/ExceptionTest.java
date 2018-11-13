package Exception;

import org.junit.Test;

/**
 * Created by hcj on 18-5-21
 */
public class ExceptionTest {


  public void test() throws SuperException {
      int i=0;
      if(i==0){
        throw new SubException();
      }
  }


  @Test
  public void test1(){
    try {
      test();
    } catch (SubException e) {
      System.out.println("子");
      e.printStackTrace();

    } catch (SuperException e) {
      System.out.println("父");
      e.printStackTrace();
    }

  }


}
