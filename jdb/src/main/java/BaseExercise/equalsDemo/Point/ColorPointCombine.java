package BaseExercise.equalsDemo.Point;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-8-12
 */
@Setter
@Getter
@ToString
public class ColorPointCombine  {

  private Color color;
  // 复合解决
  private Point point;
  private int xx;
  private boolean flag;


  public ColorPointCombine(Color color) {
    this.color = color;

  }
  public Point asPoint(){
    return point;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ColorPointCombine)) {
      return false;
    }
    ColorPointCombine that = (ColorPointCombine) o;
    return xx == that.xx &&
        flag == that.flag &&
        color == that.color &&
        Objects.equals(point, that.point);
  }

  @Override
  public int hashCode() {

    return Objects.hash(color, point, xx, flag);
  }
//  @Override
//  public boolean equals(Object obj) {
//    // null
//    if (!(obj instanceof ColorPointCombine)) {
//      return false;
//    }
//    ColorPointCombine obj1 = (ColorPointCombine) obj;
//    // 枚举类型比较,  直接==  相同点,
//    return obj1.asPoint().equals(point) && obj1.getColor().equals(color);
//
//  }

//  @Override
//  public int hashCode() {
//    return super.hashCode();
//  }
}
