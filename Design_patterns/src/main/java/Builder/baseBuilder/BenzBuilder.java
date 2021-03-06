package Builder.baseBuilder;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-7
 */
public class BenzBuilder extends CarBuilder{
  // 保证对象唯一
  private  CarModel benz = new BenzModel();
  @Override
  public void setSequence(ArrayList<String> sequence) {
    this.getCarModel().setSequence(sequence);
  }

  @Override
  public CarModel getCarModel() {
    // 获取建造者模型信息
    return this.benz;
  }
}
