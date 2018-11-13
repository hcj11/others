package composite.traverse;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public class Branch extends Corp {

  private ArrayList<Corp> list = new ArrayList<Corp>();

  public Branch(String name, int salary, String position) {
    // 自己就不要有变量了吧
    super(name,salary,position);
  }

  public void add(Corp corp) {
    // 设计当前对象为父对象
    corp.setParent(this);
    this.list.add(corp);
  }

  // 从属关系信息
  public ArrayList getSuborinateInfo() {
    // 遍历
    return this.list;
  }

}
