package bridge;


/**
 * Created by hcj on 18-7-9
 */
public abstract class Corp  {
  public Product product;
  public Corp(Product product){
    this.product=product;
  }
  public  void makeMoney(){
    // 定义好挣钱的途径,而不管怎么是怎么挣钱的
    this.product.beProducted();
    this.product.beSelled();
  }

}
