package Decorator;

/**
 * Created by hcj on 18-7-8
 */
public class SortDecorator extends Decorator {
  public SortDecorator(SchoolReport fouthGradeSchoolReport) {
    super(fouthGradeSchoolReport);
  }

  public void reportSortScore(){
    System.out.println("我在全校排名还是靠前的,考了100名,  主要是我们班的整体实力太强了");
  }
  public void report(){
    // 注意这里的先后顺序.,就会产生不同的变化,
    super.report();
    this.reportSortScore();
  }




}
