package Factory.shrinkProduce;

/**
 * 直接工厂.,因为只有一个生产产品的情形 ,无需抽象
 * Created by hcj on 18-7-7
 */
public class HumanFactory {

  public <T extends Human> T createHuman(Class<T> c) {
    // 根据类进行加载创建对象 ,用父类强转?
    try {
      Class<?> aClass = Class.forName(c.getName());
      return (T) aClass.newInstance();
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
    return null;
  }
}
