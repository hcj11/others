package Accessor.MultiVistor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-8
 */
@Setter
@Getter
@ToString
public class CommonnEmployee extends Employee {
  // 普通员工看工作
    private String job;


  @Override
  public void accept(IVistor vistor) {
    vistor.visit(this);
  }
}
