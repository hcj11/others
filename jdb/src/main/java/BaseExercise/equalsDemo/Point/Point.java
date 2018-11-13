package BaseExercise.equalsDemo.Point;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-8-12
 */
@Setter
@Getter
@ToString
public class Point {

  private int x;
  private int y;

  public Point() {
    Color[] values = Color.values();


  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    // 单独返回语句

    if (!(obj instanceof Point)) {
      return false;
    }
    Point obj1 = (Point) obj;
    return obj1.x == this.x && obj1.y == this.y;
  }

}
