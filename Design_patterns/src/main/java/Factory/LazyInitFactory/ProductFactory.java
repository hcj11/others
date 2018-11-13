package Factory.LazyInitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 延迟初始化工厂类  ,在对象被消费完毕后,并不释放,保持初始化状态,并等待再次被使用 Created by hcj on 18-7-7
 *
 * 作用: 限制最大实例化数量,即 map的大小
 */
public class ProductFactory {

  public static Map<String, Product> productMap = new HashMap<>();

  public static synchronized Product createProduct(String type) {

    Product product = productMap.get(type);
    if (product == null) {
      // 创建
      ConcreteProduct concreteProduct = new ConcreteProduct();

      productMap.put(type, concreteProduct);
      return concreteProduct;
    }
    return product;
  }
}
