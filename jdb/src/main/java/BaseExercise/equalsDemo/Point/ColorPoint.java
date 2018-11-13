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
public class ColorPoint extends Point {

  private Color color;
//  // 复合
//  private Point point;

  public ColorPoint(Color color, int x, int y) {
    super(x, y);
    this.color = color;

  }

  @Override
  public boolean equals(Object obj) {
    // null
    if (!(obj instanceof Point)) {
      return false;
    }
    if (!(obj instanceof ColorPoint)) {
      return super.equals(obj);
    }
    ColorPoint obj1 = (ColorPoint) obj;
    // 枚举类型比较,  直接==  相同点,
    return super.equals(obj) && obj1.getColor().equals(color);


  }
}
