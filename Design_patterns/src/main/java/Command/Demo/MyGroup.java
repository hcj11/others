package Command.Demo;

/**
 * Created by hcj on 18-7-12
 */
public class MyGroup implements Group {

  @Override
  public void find() {
    System.out.println("mygroup find ");
  }

  @Override
  public void update() {
    System.out.println("mygroup update ");
  }

  @Override
  public void del() {
    System.out.println("mygroup del ");
  }
}
