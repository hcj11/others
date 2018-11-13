package BankSystem;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-12
 */
@Setter
@Getter
public class DeductionContext {
  // 策略模式
  private IDeduction iDeduction;

}
