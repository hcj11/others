package Agent;

/**
 * 定义多个职位信息,由 子类来调用
 * Created by hcj on 18-7-8
 */
public class AbstractCollege {
  // 未提供默认构造器,那么子类就无法用 无参构造器
  protected AbstractMediator abstractMediator;
  // 就是用来实现,
  public AbstractCollege(AbstractMediator abstractMediator){
    this.abstractMediator=abstractMediator;
  }
}
