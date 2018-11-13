package Accessor.MultiVistor;

/**
 * Created by hcj on 18-7-8
 */
public class ShowVistor implements IShowVistor {
  private StringBuilder sb = new StringBuilder(8196);
  // 看工作,打印报表
  @Override
  public void visit(CommonnEmployee commonnEmployee) {
    this.sb.append("他叫"+commonnEmployee.getName()+" 工作: "+commonnEmployee.getJob()+" 薪资:"+commonnEmployee.getSalary()).append("\n");
  }


  // 看业绩,打印报表
  @Override
  public void visit(Manager manager) {
    this.sb.append("他叫"+manager.getName()+" 业绩: "+manager.getPerformance()+" 薪资:"+manager.getSalary()).append("\n");
  }

  @Override
  public void report() {
    // 出报告
    System.out.println("出报告内容: \n"+ this.sb.toString());
  }
}
