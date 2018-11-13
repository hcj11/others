package composite.base;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public class Branch implements IBranch {

  private ArrayList<ICorp> list = new ArrayList<ICorp>();
  private String name;
  private int salary = 0;
  private String position;

  public Branch(String name, int salary, String position) {
    this.name = name;
    this.salary = salary;
    this.position = position;
  }

  //  管理层的信息 得到该用户的详细信息
  @Override
  public String getInfo() {
    return "姓名: " + this.name + " 职位: " + this.position + "薪水: " + this.salary;
  }

  @Override
  public void add(ICorp corp) {
    this.list.add(corp);
  }

  // 从属关系信息
  @Override
  public ArrayList getSuborinateInfo() {
    // 遍历
    return this.list;
  }

}
