package bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-13
 */
@Setter
@Getter
public class Student  implements User{
  private String id;
  public Student(){}
  public Student(String id ){
    this.id=id;
  }

  @Override
  public void getname() {
    System.out.println("hello ,my name is stu");
  }
}
