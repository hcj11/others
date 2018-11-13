package composite.Sort.traverse;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public class Leaf extends Corp {

  private String name;
  private int salary = 0;
  private String position;

  public Leaf(String name, int salary, String position) {
    super(name, salary, position);
  }
}
