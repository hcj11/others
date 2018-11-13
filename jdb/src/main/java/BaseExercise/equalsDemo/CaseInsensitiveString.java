package BaseExercise.equalsDemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-8-12
 */
@Setter
@Getter
@ToString
public final class CaseInsensitiveString {

  private String s = null;

  public CaseInsensitiveString(String s) {
    if (s == null) {
      throw new NullPointerException();
    }
    this.s = s;
  }

  @Override
  public boolean equals(Object obj) {
    // 单独返回语句
    if (obj instanceof CaseInsensitiveString) {
      return ((CaseInsensitiveString) obj).getS().equalsIgnoreCase(s);
    }
//    if (obj instanceof String) {
//      return ((String) obj).equalsIgnoreCase(s);
//    }
    return false;
  }

}
