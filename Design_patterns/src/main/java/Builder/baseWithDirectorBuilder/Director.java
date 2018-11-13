package Builder.baseWithDirectorBuilder;

import java.util.ArrayList;

/**
 * 导演类进行统筹
 * Created by hcj on 18-7-7
 */
public class Director {
  public CarModel getABenzModel(){
    BenzBuilder benzBuilder = new BenzBuilder();
    ArrayList<String> str = new ArrayList<>();
    str.add("start");
    benzBuilder.setSequence(str);
    CarModel carModel = benzBuilder.getCarModel();
    return carModel;
  }
  public CarModel getBBenzModel(){
    BenzBuilder benzBuilder = new BenzBuilder();
    ArrayList<String> str = new ArrayList<>();
    str.add("stop");
    benzBuilder.setSequence(str);
    CarModel carModel = benzBuilder.getCarModel();
    return carModel;
  }
  public CarModel getABMWModel(){
    BenzBuilder benzBuilder = new BenzBuilder();
    ArrayList<String> str = new ArrayList<>();
    str.add("alarm");
    str.add("stop");
    benzBuilder.setSequence(str);
    CarModel carModel = benzBuilder.getCarModel();
    return carModel;
  }
  public CarModel getBBMWModel(){
    BenzBuilder benzBuilder = new BenzBuilder();
    ArrayList<String> str = new ArrayList<>();
    str.add("alarm");
    str.add("start");
    benzBuilder.setSequence(str);
    CarModel carModel = benzBuilder.getCarModel();
    return carModel;
  }

}
