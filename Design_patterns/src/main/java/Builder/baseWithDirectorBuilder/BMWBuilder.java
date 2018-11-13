package Builder.baseWithDirectorBuilder;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-7
 */
public class BMWBuilder extends CarBuilder {

  // 保持对象的唯一
  private CarModel bMWModel = new BMWModel();

  @Override
  public void setSequence(ArrayList<String> sequence) {
    this.getCarModel().setSequence(sequence);

  }

  @Override
  public CarModel getCarModel() {
    // 获取建造者模型信息
    return this.bMWModel;
  }
}
