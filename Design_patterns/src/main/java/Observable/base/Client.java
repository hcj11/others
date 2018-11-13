package Observable.base;


/**
 * 观察者模式 -> 发布订阅模式, 一个对象的变化影响其他对象的状态
 * 缺点:
 * 1. 多级触发效率令人担忧
 *
 * 场景:
 * 1.跨系统的消息交换场景,如消息队列的处理机制
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      HanFeiZi hanFeiZi = new HanFeiZi();
      hanFeiZi.addObserver(new LiSi());
      hanFeiZi.addObserver(new WangSi());
      hanFeiZi.haveBreakfast();
      hanFeiZi.haveFun();
//      hanFeiZi.notifyObserver("更新观察者的动向啦...");

    }
}
