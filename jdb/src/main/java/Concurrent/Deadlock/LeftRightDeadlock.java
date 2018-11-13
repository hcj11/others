package Concurrent.Deadlock ;

/**
 * 静态锁顺序死锁
 * Created by hcj on 18-5-6
 */
public class LeftRightDeadlock {
  // 保持锁引用不变,
  private final Object left = new Object();
  private final Object right = new Object();

  public void leftRight(){
      synchronized (left){
        synchronized (right){
            System.out.println(left.hashCode()+" : "+right.hashCode());
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
  }

  public  void rightLeft(){
    synchronized (right){
      synchronized (left){
        System.out.println(left.hashCode()+" : "+right.hashCode());
        // 过久的持有锁，就可能会导致死锁现象
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
