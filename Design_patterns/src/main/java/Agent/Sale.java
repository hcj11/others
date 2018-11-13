package Agent;

import java.util.Random;

/**
 * Created by hcj on 18-7-8
 */
public class Sale extends AbstractCollege {


  public Sale(AbstractMediator abstractMediator) {
    super(abstractMediator);
  }

  public void sellIBMComputer(int number) {
    this.abstractMediator.execute("sale.sell", number);
  }

  public int getSaleStatus() {
    Random random = new Random();
    int i = random.nextInt(100);
    System.out.println("销售情况:" + i);
    return i;
  }

  public void offSale() {
    //折半出售
    this.abstractMediator.execute("sale.offsell");
  }

}
