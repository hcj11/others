package Observable.extend;

/**
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      HanFeiZi hanFeiZi = new HanFeiZi();
      hanFeiZi.addObserver(new LiSi());
      hanFeiZi.addObserver(new WangSi());
      hanFeiZi.haveBreakfast();
      hanFeiZi.haveFun();


    }
}
