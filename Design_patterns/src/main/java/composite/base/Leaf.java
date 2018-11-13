package composite.base;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public class Leaf implements ILeaf{
  private String name;
  private int salary=0;
  private String position;
  public Leaf(String name, int salary, String position) {
    this.name = name;
    this.salary = salary;
    this.position = position;
  }
  @Override
  public String getInfo() {
    return "姓名: "+this.name+" 职位:"+this.position+"薪水: "+this.salary;
  }
}
