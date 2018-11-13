package Command;

/**
 * Created by hcj on 18-7-8
 */
public abstract class Command {
  // 组成员不要随意改顺序
  protected final Group requirementGroup = new RequirementGroup();
  protected final Group codeGroup = new CodeGroup();
  protected final Group pageGroup = new PageGroup();

  public void execute() {
      // 根据类型区分 ,由子类复写
  }

}
