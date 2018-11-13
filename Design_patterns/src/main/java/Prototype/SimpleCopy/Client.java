package Prototype.SimpleCopy;


/**
 * 浅拷贝
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      simpleThingingOne();
      simpleThingingTwo();
    }

  private static void simpleThingingOne() {
  // 深拷贝后, 对原对象的数据不做变化,   只对clone后的数据是基于现有的数据进行的拷贝
    Thinging thinging = new Thinging();
    thinging.getList().add("1");
    System.out.println(thinging.getList().size());

    Thinging clone = thinging.clone();
    clone.getList().add("2");
    System.out.println(thinging.getList().size());

  }
  private static void simpleThingingTwo() {
    // 深拷贝后, 对原对象的数据不做变化,   只对clone后的数据是基于现有的数据进行的拷贝
    Thinging thinging = new Thinging();
    thinging.setValue("1");
    System.out.println(thinging.getList().size());
    
    Thinging clone = thinging.clone();
    clone.setValue("2");
    System.out.println(thinging.getList().size());

  }
}
