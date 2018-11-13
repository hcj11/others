package BaseExercise.equalsDemo;

import java.util.ArrayList;

/**
 * 对称性 Created by hcj on 18-8-12
 *
 */
public class Demo {

  public static void main(String[] args) {
    demo1();
    demo11();
    demo2();
    demo3();


  }

  private static void demo11() {
    CaseInsensitiveString polish = new CaseInsensitiveString("Polish");
    boolean polish1 = polish.equals(new CaseInsensitiveString("polish"));
    System.out.println(polish1);
  }

  private static void demo3() {
    ArrayList<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
    CaseInsensitiveString polish = new CaseInsensitiveString("Polish");
    list.add(polish);
    boolean polish1 = list.contains("polish");
    System.out.println(polish1);

  }

  private static void demo2() {
    CaseInsensitiveString polish = new CaseInsensitiveString("Polish");
    String ss="polish";
    boolean equals = ss.equals(polish);
    System.out.println(equals);
  }

  private static void demo1() {
    CaseInsensitiveString polish = new CaseInsensitiveString("Polish");
    boolean polish1 = polish.equals("polish");
    System.out.println(polish1);

  }
}
