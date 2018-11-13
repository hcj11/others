package com.Domain;

import com.Domain.Page.PageParams;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

//@Lazy
@Setter
@Getter
public class User extends PageParams implements Serializable{
  public static final long serialVersionUID = 1L;
  private Integer id;
  private String username;
  private String password;
  private Sex sex;
  private boolean enabled;
  private UserIdentity userIdentity;
  private Integer roleId;
  private List<FeMaleHealth> feMaleHealths;
  private List<MaleHealth> maleHealths;




//  @Override
//  public String toString() {
//    return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ""
//        + "Sex: " + sex.getValue(sex.getSex()) + "]";
//  }

}