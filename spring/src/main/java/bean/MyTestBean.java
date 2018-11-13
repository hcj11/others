package bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by hcj on 18-7-13
 */
@Setter
@Getter
public class MyTestBean {

//  @Autowired
//  public User user;

  private String strTest="hahaha";
  private String id;
//  public void getnameTest(){
//    user.getname();
//  }

//  public MyTestBean(String s) {
//    // id 引用?
//    this.id=s;
//  }
}
