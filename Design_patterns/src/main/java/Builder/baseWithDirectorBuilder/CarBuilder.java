package Builder.baseWithDirectorBuilder;

import Builder.baseBuilder.Builder;
import java.util.ArrayList;

/**
 * Created by hcj on 18-7-7
 */
public abstract class CarBuilder {

  // 使得同样的构建过程可以创建不同的表示
  public abstract void setSequence(ArrayList<String> sequence);

  public abstract CarModel getCarModel();

}
