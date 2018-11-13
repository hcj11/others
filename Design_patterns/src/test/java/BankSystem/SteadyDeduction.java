package BankSystem;

/**
 * Created by hcj on 18-7-12
 */
public class SteadyDeduction implements IDeduction {
  // 固定扣费
  @Override
  public void exec(Trade trade, Card card) {
    Integer steadyMoney = card.getSteadyMoney();
    Integer freeMoney = card.getFreeMoney();
    // 交易金额
    Integer amount = trade.getAmount();
    int steadyMoneyFree = steadyMoney - (int)Math.rint(amount / 2.0);
    int freeMoneyFree = freeMoney - (int)Math.rint(amount / 2.0);

    card.setSteadyMoney(steadyMoneyFree);
    card.setFreeMoney(freeMoneyFree);
  }
}

