package BankSystem;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-12
 */
@Setter
@Getter
public class Card {
  public Card(Integer cardNo,Integer freeMoney,Integer steadyMoney){
      this.cardNo=cardNo;
      this.freeMoney=freeMoney;
      this.steadyMoney=steadyMoney;
  }

  @Override
  public String toString() {
    return  "卡号是:" + this.getCardNo() + " \n自有金额: "
        + this.getFreeMoney() + " \n固定金额 "+this.getSteadyMoney();
  }

  // 卡号
  private Integer cardNo;
  // 卡上自有消费金额
  private Integer freeMoney;
  // 卡上固定消费金额
  private Integer steadyMoney;
}
