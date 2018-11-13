package Accessor.MultiVistor;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public abstract class Employee {

  private int salary = 0;
  private String name;
  private int sex;


  public abstract void accept(IVistor vistor);
}
