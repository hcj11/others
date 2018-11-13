package Strategy.base;

/**
 * 上下文 Created by hcj on 18-7-8
 */
public abstract class Context {

  private IStrategy iStrategy;

  public Context(IStrategy strategy) {
    this.iStrategy = strategy;
  }

  public void operate() {
    iStrategy.operate();
  }

}
