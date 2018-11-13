package Prototype.SimpleCopy;

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

  @Override
  public Thinging clone() {
    Thinging clone = null;
    try {
      clone = (Thinging) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }

}
