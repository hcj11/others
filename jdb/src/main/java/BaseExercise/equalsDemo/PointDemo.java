package BaseExercise.equalsDemo;

import BaseExercise.equalsDemo.Point.Color;
import BaseExercise.equalsDemo.Point.ColorPoint;
import BaseExercise.equalsDemo.Point.ColorPointCombine;
import BaseExercise.equalsDemo.Point.Point;

/**
 * Created by hcj on 18-8-12
 */
public class PointDemo {
    public   static  void main(String[] args){
      // 对称性
//      demo1();
      // 传递性
//      demo2();
      // 通过扩展
      demo3();

    }

  private static void demo3() {
    ColorPointCombine colorPointCombine = new ColorPointCombine(Color.RED);
    colorPointCombine.setPoint(new Point(2,3));
    ColorPointCombine colorPointCombine1 = new ColorPointCombine(Color.BLUE);
    colorPointCombine1.setPoint(new Point(2,3));

    boolean equals = colorPointCombine.equals(colorPointCombine1);
    System.out.println(equals);
    boolean equals1 = colorPointCombine1.equals(colorPointCombine);
    System.out.println(equals1);

  }

  private static void demo2() {
    Point point1 = new Point(1,2);
    Point point2 = new ColorPoint(Color.RED,2,3);
    Point point3 = new ColorPoint(Color.BLUE,2,3);
    Point point4 = new Point(2,3);
    // 满足对称性
    System.out.println(point1.equals(point2));
    System.out.println(point2.equals(point1));
    // 牺牲传递性
    System.out.println(point2.equals(point3));
    System.out.println(point2.equals(point4));
    System.out.println(point3.equals(point4));
  }

  private static void demo1() {
    Point point1 = new Point(1,2);
    Point point2 = new Point(2,3);
    Point point3 = new Point(2,3);
    Point point4 = new Point(2,3);
    System.out.println(point1.equals(point2));
    System.out.println(point2.equals(point3));
    System.out.println(point2.equals(point4));



  }
}
