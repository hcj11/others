package com.Domain;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-18
 */
@Setter
@Getter
public class Role implements Serializable{
  public static final long serialVersionUID = 42L;
  private Integer id;
  private String rolename;
  private List<User> userList;
}
