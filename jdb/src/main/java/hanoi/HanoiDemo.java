package hanoi;

/**
 * Created by hcj on 18-3-10
 */
public class HanoiDemo {

  /***
   *
   * @param n
   * @param a
   * @param b
   * @param c
   */
  // 将
  public void move(int n, String a, String b, String c) {

    if (n == 0) {
      return;
    }
    // 首先 n-1 个盘子由 a->c 经过b
    // 2,"a","c","b"  / 1,"a","b","c", / 0,
    move(n - 1, a, c, b);

    printEnd(n, a, b); // 打印第n个盘子由 a->b
    // 最后将n-1个盘子 c 移动到b ，经过a
    move(n - 1, c, b, a);
  }

  private void printEnd(int n, String a, String b) {
    String stringBuffer = "第" + n + "个盘子从"
        + a
        + "移动到" + b;
    System.out.println(stringBuffer);
  }


  public static void main(String[] args) {
    HanoiDemo hanoiDemo = new HanoiDemo();
    int n = 30; // 3个盘子
    hanoiDemo.move(n, "a", "b", "c");
  }
}
