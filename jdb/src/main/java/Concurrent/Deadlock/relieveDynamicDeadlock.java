package Concurrent.Deadlock;

/**
 * 解除 动态锁顺序死锁 ---转账 Created by hcj on 18-5-6
 */
public class relieveDynamicDeadlock {

  public void transferMoney(Acount fromAccount, Acount toAccount, DollarAmount amount) {
    class Helper {
      public void transfer() {
        synchronized (fromAccount) {
          synchronized (toAccount) {
            // 不变性条件
            if (fromAccount.getBalance().compareTo(amount) < 0) {
              throw new InsufficientFundsException();
            } else {
              fromAccount.debit(amount); // -
              toAccount.cebit(amount); // +
            }
          }
        }
      }

    }
    int fromHash =System.identityHashCode(fromAccount);
    int toHash =System.identityHashCode(toAccount);

  }



  public static void main(String[] args) {
    relieveDynamicDeadlock dynamicDeadlock = new relieveDynamicDeadlock();
    Acount fromAccount = new Acount(0);

    Acount toAccount = new Acount(0);

    DollarAmount dollarAmount = new DollarAmount(10);

    dynamicDeadlock.transferMoney(fromAccount, toAccount, dollarAmount);

    System.out.println(fromAccount.getBalance().getAmount());
    System.out.println(toAccount.getBalance().getAmount());
  }


}
