package Flyweight.extend;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-9
 */
@Setter
@Getter
public class SignInfo4Pool extends SignInfo {
  private ExtrinsicState key;

  public SignInfo4Pool(ExtrinsicState key){
    this.key=key;
  }

}
