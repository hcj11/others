package Concurrent.Deadlock;

import lombok.Getter;

/**
 * Created by hcj on 18-5-6
 */
@Getter
public class Acount {

  private DollarAmount balance;

  public Acount(int amount) {
    balance = new DollarAmount(amount);
  }

  /**
   * 扣款 Created by hcj on 18-5-6.
   */
  public void debit(DollarAmount amount) {
    int amount1 = balance.getAmount();
    amount1 -= amount.getAmount();
    balance.setAmount(amount1);
  }

  /**
   * 加钱 Created by hcj on 18-5-6.
   */
  public void cebit(DollarAmount amount) {
    int amount1 = balance.getAmount();
    amount1 += amount.getAmount();
    balance.setAmount(amount1);
  }
}
