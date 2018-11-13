package BankSystem;

/**
 * Created by hcj on 18-7-12
 */
public interface IDeduction {
  // 根据 trade and ICard
  public  void exec(Trade trade,Card card);
}
