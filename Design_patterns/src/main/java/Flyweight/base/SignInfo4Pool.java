package Flyweight.base;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-9
 */
@Setter
@Getter
public class SignInfo4Pool extends SignInfo {
  private String key;

  public SignInfo4Pool(String key){
    this.key=key;
  }
}
