package BaseExercise;

/**
 * Created by hcj on 18-8-8
 */
public class ThreadDemo {

  public static void main(String[] args) {
    Thread thread = new Thread() {
      @Override
      public void run() {
        poo();
      }
    };
    thread.start();
    System.out.println("patte");

  }

  static void poo() {
    System.out.println("hello");
  }

}
