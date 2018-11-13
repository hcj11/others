package BankSystem;

/**
 * Created by hcj on 18-7-12
 */
public class FreeDeduction implements IDeduction {
  // 固定扣费
  @Override
  public void exec(Trade trade, Card card) {
    Integer freeMoney = card.getFreeMoney();
    // 交易金额, 自有金额不足的问题的处理方法
    Integer amount = trade.getAmount();
    int freeMoneyFree = freeMoney-amount;

    card.setFreeMoney(freeMoneyFree);
  }
}

