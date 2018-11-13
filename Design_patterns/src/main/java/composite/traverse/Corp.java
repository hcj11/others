package composite.traverse;

/**
 * Created by hcj on 18-7-8
 */
public abstract class Corp {

  private String name;
  private int salary = 0;
  private String position;
  public Corp(String name, int salary, String position) {
    this.name = name;
    this.salary = salary;
    this.position = position;
  }

  private Corp parent = null;

  public String getInfo() {
    return "姓名: " + this.name + " 职位:" + this.position + "薪水: " + this.salary;
  }

  protected void setParent(Corp corp) {
    this.parent = corp;
  }

  public Corp getParent() {
    return this.parent;
  }
}
