package BuilderDemo;

/**
 * Created by hcj on 18-7-12
 */
public class Director {
  private CarBuilder benzBuilder = new BenzBuilder();
  private CarBuilder bmwBuilder = new BMWBuilder();

  public ICar benzBuilder(CarBuilder carBuilder,String sheel,String engine){
    // 核心就是构建 , 通过;蓝图来构建
    Blueprint blueprint = new Blueprint();
    blueprint.setWheel(sheel);
    blueprint.setEngine(engine);
    carBuilder.receiveBlueprint(blueprint);
    return carBuilder.buildCar();
  }
  public ICar createBenzSuv(){
   return benzBuilder(benzBuilder,"宝马车轮","SUV");
  }
  public ICar createBMWVan(){
    return benzBuilder(bmwBuilder,"奔驰车轮","Van系列");
  }
  public ICar createComplexCar(){
    return benzBuilder(bmwBuilder,"宝马车轮","复杂");
  }
}
