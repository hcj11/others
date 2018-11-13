package Agent;

/**
 * 库存类 Created by hcj on 18-7-8
 */
public class Stock extends AbstractCollege {

  public Stock(AbstractMediator abstractMediator) {
    super(abstractMediator);
  }

  private int numberInit = 50;

  public void increase(int number) {
    this.numberInit = this.numberInit + number;
  }

  public void decrease(int number) {
    this.numberInit = this.numberInit - number;
    System.out.println("当前库存: " + numberInit);
  }

  public int getStockNumber() {
    // 库存数量
    return this.numberInit;
  }

  public void clearStock() {
    // 清理库存 ,通知采购人员不要采购,  销售人员尽快销售
    // 就是容易绕糊涂,,,,
    System.out.println("清空仓库,全部上架,当前库存是:" + this.abstractMediator.stock.numberInit);
    this.numberInit = 0;
    abstractMediator.execute("stock.clear");
  }
}
