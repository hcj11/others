package BankSystem;

/**
 * 策略工厂,封装策略
 * Created by hcj on 18-7-12
 */
public class StrategyFactory<T> {
  public static <T> T buildStategy(String classname){
    try {
      return (T) Class.forName(classname).newInstance();
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
    return null;
  }
}
