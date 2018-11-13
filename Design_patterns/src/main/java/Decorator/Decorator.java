package Decorator;

/**
 * Created by hcj on 18-7-8
 */
public abstract class Decorator implements SchoolReport {

  private SchoolReport fouthGradeSchoolReport;
  public Decorator(SchoolReport fouthGradeSchoolReport){
    this.fouthGradeSchoolReport=fouthGradeSchoolReport;
  }

  @Override
  public  void report(){
    // 报告方式也是相同的啊, 也可以用到模板方法
    this.fouthGradeSchoolReport.report();
  }

  @Override
  public  void sign(String name){
    // 签名的方式都是相同的
    this.fouthGradeSchoolReport.sign(name);
  }

}
