package Builder.baseBuilder;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      benzBuilder();

//      bmwBuilder();
    }

  private static void bmwBuilder() {
    // 建造者的顺序 设计
    BMWBuilder bmwBuilder = new BMWBuilder();
    ArrayList<String> benzs = new ArrayList<>();
    benzs.add("alarm");
    benzs.add("start");
    benzs.add("engineBoom");
    bmwBuilder.setSequence(benzs);
    // BMWModel 接的话 ,就走子类的方法 ,执行子类的特有方法,
    BMWModel carModel = (BMWModel) bmwBuilder.getCarModel();
    carModel.setAlarm(true);
    carModel.run();
  }

  private static void benzBuilder() {
    // 建造者的顺序 设计
    BenzBuilder benzBuilder = new BenzBuilder();
    ArrayList<String> benzs = new ArrayList<>();
    benzs.add("alarm");
    benzs.add("start");
    benzs.add("engineBoom");
    benzBuilder.setSequence(benzs);
    // BMWModel 接的话 ,就走子类的方法,执行子类的特有方法,
    CarModel carModel =  benzBuilder.getCarModel();
    carModel.run();
  }
}
