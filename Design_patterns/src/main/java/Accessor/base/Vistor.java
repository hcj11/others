package Accessor.base;

/**
 * Created by hcj on 18-7-8
 */
public class Vistor implements IVistor {

  private static final int Common_Cardinal_Number = 1;
  private static final int Manager_Cardinal_Number = 5;
  private int commonTotalSalary = 0;
  private int managerTotalSalary = 0;

  // 看工作,打印报表
  @Override
  public void visit(CommonnEmployee commonnEmployee) {
    System.out.println(this.getcommonnEmployee(commonnEmployee));
  }

  private String getcommonnEmployee(Employee commonnEmployee) {
    calCommonTotal(commonnEmployee.getSalary());
    return commonnEmployee.toString();
  }

  // 看业绩,打印报表
  @Override
  public void visit(Manager manager) {
    calManageTotal(manager.getSalary());
    System.out.println(manager);
  }

  private void calCommonTotal(int salary) {
    this.commonTotalSalary += salary * Common_Cardinal_Number;
  }

  private void calManageTotal(int salary) {
    this.managerTotalSalary += salary * Manager_Cardinal_Number;
  }


  @Override
  public int getTotalSalary() {
    // 统计公司员工的总金额 ,员工和经理的工资是不一样的
    return this.commonTotalSalary + this.managerTotalSalary;
  }
}
