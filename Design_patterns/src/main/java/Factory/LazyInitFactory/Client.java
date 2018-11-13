package Factory.LazyInitFactory;

/**
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      ProductFactory productFactory = new ProductFactory();
      Product product1 = productFactory.createProduct("哈哈哈");
      product1.doSomeThing();
      Product product2 = productFactory.createProduct("哈哈哈");
      product2.doSomeThing();
    }
}
