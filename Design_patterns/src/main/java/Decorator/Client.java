package Decorator;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 装饰器模式
 * 特殊的代理模式
 *  真实的执行者还是被代理者, 只是通过了decorator进行了修饰
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      SchoolReport report;
      //                              super()               super()
      // 修饰链, FouthGradeSchoolReport -> HighScoreDecorator->SortDecorator
      report = new FouthGradeSchoolReport();
      report = new HighScoreDecorator(report);
      report = new SortDecorator(report);
      report.report();
      report.sign("老侯");
//      try {
//        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File("")));
//        dataOutputStream.write();
//      } catch (FileNotFoundException e) {
//        e.printStackTrace();
//      }
    }
}
