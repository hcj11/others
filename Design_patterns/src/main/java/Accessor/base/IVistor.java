package Accessor.base;

/**
 * Created by hcj on 18-7-8
 */
public interface IVistor {
  public void visit(CommonnEmployee commonnEmployee);
  public void visit(Manager manager);
  public int getTotalSalary();
}
