package Accessor.MultiVistor;


/**
 * 多访问者 , 分别提供内容,可扩展...
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      // 1: 男, 2: 女
      ShowVistor vistor = new ShowVistor();
      TotalVistor totalVistor = new TotalVistor();
      CommonnEmployee zhangsan = new CommonnEmployee();
      zhangsan.setJob("码农");
      zhangsan.setName("张三");
      zhangsan.setSalary(12);
      zhangsan.setSex(1);
      CommonnEmployee lisi = new CommonnEmployee();
      lisi.setJob("码农");
      lisi.setName("李斯");
      lisi.setSalary(13);
      lisi.setSex(1);
      zhangsan.accept(vistor);
      lisi.accept(vistor);
      zhangsan.accept(totalVistor);
      lisi.accept(totalVistor);


      // 代码管理者
      Manager wangwu = new Manager();
      wangwu.setPerformance("老码农管理的业绩很棒啊!!!");
      wangwu.setName("王五");
      wangwu.setSalary(14);
      wangwu.setSex(2);
      wangwu.accept(vistor);
      wangwu.accept(totalVistor);
      // 参观者.
      vistor.report();
      totalVistor.totalSalary();

//      System.out.println(vistor.getTotalSalary());
      
    }
}
