package Command;

/**
 * Created by hcj on 18-7-8
 */
public interface Group {
  public void find();
  public void add();
  public void delete();
  public void change();
  public void plan();
  // 突然我想反悔,不要那么做了
  public  void rollback();
}
