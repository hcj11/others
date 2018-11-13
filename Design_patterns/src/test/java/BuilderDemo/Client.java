package BuilderDemo;

/**
 * Created by hcj on 18-7-12
 */
public class Client {
    public   static  void main(String[] args){
      Director director = new Director();
      ICar benzSuv = director.createBenzSuv();
      System.out.println(benzSuv);
      ICar bmwVan = director.createBMWVan();
      System.out.println(bmwVan);
      ICar complexCar = director.createComplexCar();
      System.out.println(complexCar);

    }
}
