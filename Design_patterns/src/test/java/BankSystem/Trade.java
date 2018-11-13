package BankSystem;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-12
 */
@Setter
@Getter
public class Trade  {
  // 交易编号
  private Integer tradeno;
  // 交易金额
  private Integer amount;
  public Trade(Integer tradeno,Integer amount){
      this.tradeno=tradeno;
      this.amount=amount;
  }

  @Override
  public String toString() {
    return  "交易编号:" + this.getTradeno() + " \n交易金额: "+this.getAmount();
  }
}
