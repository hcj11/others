package Command;

/**
 * Created by hcj on 18-7-8
 */
public class PageGroup implements Group {

  @Override
  public void find() {
    System.out.println("find page");
  }

  @Override
  public void add() {
    System.out.println("add page");
  }

  @Override
  public void delete() {
    System.out.println("delete page");
  }

  @Override
  public void change() {
    System.out.println("change page");
  }

  @Override
  public void plan() {
    System.out.println("plan page");
  }

  @Override
  public void rollback() {

  }
}
