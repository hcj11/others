package Flyweight.extend;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-9
 */
@Getter
@Setter
public class ExtrinsicState extends SignInfo{

  private String subject;
  private String location;

  //map 的重写
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ExtrinsicState) {
      ExtrinsicState obj1 = (ExtrinsicState) obj;
      return this.location.equalsIgnoreCase(obj1.getLocation()) && this.subject
          .equalsIgnoreCase(obj1.getSubject());
    }
    return false;
  }

  @Override
  public int hashCode() {
    // 作为一个对象处理
    return this.subject.hashCode() + this.location.hashCode();
  }
}
