package bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-13
 */
@Setter
@Getter
public class Teacher implements User{
  private String id;

  @Override
  public void getname() {
    System.out.println("hello ,my name is teacher");
  }
}
