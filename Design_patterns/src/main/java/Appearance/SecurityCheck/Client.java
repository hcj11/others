package Appearance.SecurityCheck;


/**
 * 信件检查, 不改动,子类的内部结果,在外部进行修改.
 * 1. 优点:
 * 2. 缺点
 *  不符和开闭原则, 对修改关闭,对扩展开发, 不能扩展.
 * Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    ModenPostOffice modenPostOffice = new ModenPostOffice();

    modenPostOffice.sendLetter("国庆节回家!!!", "泽库镇");

  }
}
