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
public class MaleHealth extends User implements Serializable{
  public static final long serialVersionUID = 42L;
  private Integer id;
  private String common;
  private String special;

}
