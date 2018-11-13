package com.Domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-18
 */
@Setter
@Getter
@ToString
public class UserIdentity implements Serializable{
  public static final long serialVersionUID = 1L;
  private Integer id;
  private String address;
}
