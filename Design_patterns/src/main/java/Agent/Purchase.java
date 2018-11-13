package Agent;

/**
 * 进货 Created by hcj on 18-7-8
 */
public class Purchase extends AbstractCollege {
  // 每个中介者只负责分内之事
  public Purchase(AbstractMediator abstractMediator){
      super(abstractMediator);
  }
  public void buyIBMcomputer(int number) {
    // 买,由父类来管
    this.abstractMediator.execute("purchase.buy",number);
  }

  public void refuseBuyIBM() {//不买
    System.out.println("不再购买IBM的电脑");
  }
}
