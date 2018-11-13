package Agent;

/**
 * 中介者 Created by hcj on 18-7-8
 */
public class Mediator extends AbstractMediator {


  // 什么人执行什么角色 ,全让中介进行调用
  @Override
  public void execute(String str, Object... obj) {
    if (str.equals("purchase.buy")) {
      this.buyIBMcomputer((Integer) obj[0]);
    } else if (str.equals("sale.sell")) {
      this.sellIBMComputer((Integer) obj[0]);
    } else if (str.equals("sale.offsell")) {
      this.offSale(); // 打折
    } else if (str.equals("stock.clear")) {
      this.clearStock();
    }
  }

  private void clearStock() {
    // 让中介去通知....
    // 折半卖
    super.sale.offSale();
    // 通知不要购买了
    super.purchase.refuseBuyIBM();

  }

  private void offSale() {
    // 销售打折处理
//    super.sale.offSale();
    System.out.println("折半销售电脑: "+super.stock.getStockNumber()+"台");

  }

  private void sellIBMComputer(Integer integer) {
    // 若库存数量<销售数量 -> purchase继续购买
    int stockNumber = super.stock.getStockNumber();
    if (stockNumber < integer) {
      super.purchase.buyIBMcomputer(integer);
    }
    // todo 不严谨 ,都不够了, 为啥还要先减库,而不是先买, 或者可以给他,但是记一遍,给了多少,还差多少
    super.stock.decrease(integer);

  }

  private void buyIBMcomputer(Integer integer) {
    // 获取当前的销售情况
    int saleStatus = super.sale.getSaleStatus();
    if (saleStatus > 80) {
      System.out.println("继续采购电脑" + integer + "台");
      super.stock.increase(integer);
    } else {
      int buyNumber = integer / 2;
      System.out.println("折半采购");
      super.stock.increase(buyNumber);
    }
  }
}
