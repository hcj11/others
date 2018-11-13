package Prototype.DeepCopy;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-7
 */
@Getter
@Setter
public class Thinging implements Cloneable{

  private ArrayList<String> list = new ArrayList<String>();
  public void setValue(String value){
    list.add(value);
  }
  public Thinging(){
    System.out.println("构造函数被执行....");
  }
  @Override
  public Thinging clone() {
    Thinging clone = null;
    try {
      clone = (Thinging) super.clone();
      clone.list = (ArrayList<String>) this.list.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }

}
