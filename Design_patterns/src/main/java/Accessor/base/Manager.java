package Accessor.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-8
 */
@Setter
@Getter
@ToString
public class Manager extends Employee {

  // 经理看业绩
  private String performance;

  @Override
  public void accept(IVistor vistor) {
    vistor.visit(this);
  }
}
