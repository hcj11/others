package composite.lucency;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public class Leaf extends IBranch {

  private String name;
  private int salary = 0;
  private String position;

  public Leaf(String name, int salary, String position) {
    this.name = name;
    this.salary = salary;
    this.position = position;
  }

  @Override
  public void add(IBranch corp) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ArrayList getSuborinateInfo() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getInfo() {
    return "姓名: " + this.name + " 职位:" + this.position + "薪水: " + this.salary;
  }

}
