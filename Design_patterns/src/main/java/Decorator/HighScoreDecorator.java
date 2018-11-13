package Decorator;

/**
 * Created by hcj on 18-7-8
 */
public class HighScoreDecorator extends Decorator {
  public HighScoreDecorator(SchoolReport fouthGradeSchoolReport) {
    super(fouthGradeSchoolReport);
  }

  public void reportHighScore(){
    System.out.println("我们班的最高分都比较低,所以成绩就比较平均了, 60分可能都有10了多个");
  }
  public void report(){
    super.report();
    this.reportHighScore();
  }




}
