package bean.extend;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-14
 */
@ToString
@Setter
@Getter
public class SimpleBean {

  private String connect;
  private String username;
  private String password;

//  private void setConnect() {
//    this.connect = connect;
//  }
//
//  private void setUsername() {
//    this.username = username;
//  }
//
//  private void setPassword() {
//    this.password = password;
//  }
}
