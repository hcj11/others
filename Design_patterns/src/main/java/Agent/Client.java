package Agent;

/** * 进销存系统 使用中介者模式进行解耦合
 * Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    // 购买电脑
    // 构造函数进行初始化 操作 ,  先调用父类的构造函数,然后调用子类.
    AbstractMediator mediator = new Mediator();
    // 初始化三个中介
    //买电脑 ,
    System.out.println("******************买电脑前***********************");
    Purchase purchase = new Purchase(mediator);
    purchase.buyIBMcomputer(100);
    System.out.println("******************卖电脑后***********************");
    Sale sale = new Sale(mediator); // 50 +50   or 50 + 100
    sale.sellIBMComputer(1);
    System.out.println("******************清仓上架***********************");
    Stock stock = new Stock(mediator);
    stock.clearStock();


  }
}
