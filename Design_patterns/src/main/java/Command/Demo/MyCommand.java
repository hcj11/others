package Command.Demo;

/**
 * Created by hcj on 18-7-12
 */
public class MyCommand  extends Command{
  // 删除命令执行 ,, 会导致 CommandImpl 不断膨胀.
  @Override
  public void exec() {
    // 若有多个组接受相同的命令,做不同的事 则需要抽象group
    super.myGroup.find();
    super.myGroup.del();
  }
}
