package Accessor.MultiVistor;

/**
 * Created by hcj on 18-7-8
 */
public class TotalVistor implements ITotalVistor {

  private static final int Common_Cardinal_Number = 1;
  private static final int Manager_Cardinal_Number = 5;
  private int commonTotalSalary = 0;
  private int managerTotalSalary = 0;

  @Override
  public void visit(CommonnEmployee commonnEmployee) {
    calCommonTotal(commonnEmployee.getSalary());
  }

  @Override
  public void visit(Manager manager) {
    calManageTotal(manager.getSalary());
  }

  private void calCommonTotal(int salary) {
    this.commonTotalSalary += salary * Common_Cardinal_Number;
  }

  private void calManageTotal(int salary) {
    this.managerTotalSalary += salary * Manager_Cardinal_Number;
  }

  public int getTotalSalary() {
    // 统计公司员工的总金额 ,员工和经理的工资是不一样的
    return this.commonTotalSalary + this.managerTotalSalary;
  }

  @Override
  public void totalSalary() {
    System.out.println("员工总金额: "+this.getTotalSalary());
  }
}
