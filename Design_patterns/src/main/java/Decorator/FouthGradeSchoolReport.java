package Decorator;

/**
 * Created by hcj on 18-7-8
 */
public class FouthGradeSchoolReport implements SchoolReport{

  @Override
  public void report() {
    System.out.println("四年级成绩单,我考了我们班38名");
  }

  @Override
  public void sign(String name) {
    System.out.println(name+"签了字");
  }
}
