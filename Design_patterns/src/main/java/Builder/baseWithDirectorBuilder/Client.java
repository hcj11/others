package Builder.baseWithDirectorBuilder;

import Builder.baseBuilder.Builder;
import java.util.ArrayList;

/**
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
//      benzBuilder();

//      bmwBuilder();

      directorBuilderOne();
    }

  private static void directorBuilderOne() {
    new Director().getABenzModel().run();
    new Director().getBBenzModel().run();
    new Director().getABMWModel().run();
    new Director().getBBMWModel().run();


  }

//  private static void bmwBuilder() {
//    // 建造者的顺序 设计
//    Builder.baseWithDirectorBuilder.Builder.baseWithDirectorBuilder.baseBuilder.BMWBuilder bmwBuilder = new Builder.baseWithDirectorBuilder.Builder.baseWithDirectorBuilder.baseBuilder.BMWBuilder();
//    ArrayList<String> benzs = new ArrayList<>();
//    benzs.add("alarm");
//    benzs.add("start");
//    benzs.add("engineBoom");
//    bmwBuilder.setSequence(benzs);
//    // BMWModel 接的话 ,就走子类的方法 ,执行子类的特有方法,
//    Builder.baseWithDirectorBuilder.Builder.baseWithDirectorBuilder.baseBuilder.BMWModel carModel = (Builder.baseWithDirectorBuilder.Builder.baseWithDirectorBuilder.baseBuilder.BMWModel) bmwBuilder.getCarModel();
//    carModel.setAlarm(true);
//    carModel.run();
//  }
//
//  private static void benzBuilder() {
//    // 建造者的顺序 设计
//    Builder.baseWithDirectorBuilder.Builder.baseWithDirectorBuilder.baseBuilder.BenzBuilder benzBuilder = new Builder.baseWithDirectorBuilder.Builder.baseWithDirectorBuilder.baseBuilder.BenzBuilder();
//    ArrayList<String> benzs = new ArrayList<>();
//    benzs.add("alarm");
//    benzs.add("start");
//    benzs.add("engineBoom");
//    benzBuilder.setSequence(benzs);
//    // BMWModel 接的话 ,就走子类的方法,执行子类的特有方法,
//    Builder.baseWithDirectorBuilder.Builder.baseWithDirectorBuilder.baseBuilder.CarModel carModel =  benzBuilder.getCarModel();
//    carModel.run();
//  }
}
