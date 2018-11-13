package Command;

/**
 * Created by hcj on 18-7-8
 */
public class DelPageCommand extends Command {
    // 每个人的执行都不同,so,无法抽取.
  @Override
  public void execute() {
    super.pageGroup.find();
    super.pageGroup.delete();

  }
}
