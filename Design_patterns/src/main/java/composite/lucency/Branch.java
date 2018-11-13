package composite.lucency;

import composite.base.ICorp;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public class Branch extends IBranch {
  private ArrayList<IBranch> list = new ArrayList<IBranch>();
  private String name;
  private int salary = 0;
  private String position;

  public Branch(String name, int salary, String position) {
    this.name = name;
    this.salary = salary;
    this.position = position;
  }

  @Override
  public void add(IBranch corp) {
    this.list.add(corp);
  }

  @Override
  public ArrayList getSuborinateInfo() {
   return this.list;
  }

  @Override
  public String getInfo() {
    return "姓名: " + this.name + " 职位:" + this.position + "薪水: " + this.salary;
  }

}
