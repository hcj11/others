package Accessor.base;
/**
 * 访问者模式
 *  不改动原数据结构的情况下,定义一些新的操作
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      // 1: 男, 2: 女
      Vistor vistor = new Vistor();
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
      // 代码管理者
      Manager wangwu = new Manager();
      wangwu.setPerformance("老码农管理的业绩很棒啊!!!");
      wangwu.setName("王五");
      wangwu.setSalary(14);
      wangwu.setSex(2);
      wangwu.accept(vistor);
      // 参观者.
      System.out.println(vistor.getTotalSalary());


    }
}
