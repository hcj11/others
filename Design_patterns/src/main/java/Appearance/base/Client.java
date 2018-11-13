package Appearance.base;
/**
 * 门面模式,  也叫外观模式
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      ModenPostOffice modenPostOffice = new ModenPostOffice();
      modenPostOffice.sendLetter("国庆节回家!!!","泽库镇");
    }

}
