package Concurrent.Deadlock;

/**
 * 动态锁顺序死锁 ---转账 Created by hcj on 18-5-6
 */
public class DynamicDeadlock {

  public void transferMoney(Acount fromAccount, Acount toAccount, DollarAmount amount) {
    synchronized (fromAccount) {
      synchronized (toAccount) {
        // 不变性条件
        if (fromAccount.getBalance().compareTo(amount) < 0) {
          throw new InsufficientFundsException();
        }else{
          fromAccount.debit(amount); // -
          toAccount.cebit(amount); // +
        }
      }
    }
  }
    public   static  void main(String[] args){
      DynamicDeadlock dynamicDeadlock = new DynamicDeadlock();
      Acount fromAccount = new Acount(0);

      Acount toAccount = new Acount(0);

      DollarAmount dollarAmount = new DollarAmount(10);

      dynamicDeadlock.transferMoney(fromAccount,toAccount,dollarAmount);

      System.out.println(fromAccount.getBalance().getAmount());
      System.out.println(toAccount.getBalance().getAmount());
    }


}
