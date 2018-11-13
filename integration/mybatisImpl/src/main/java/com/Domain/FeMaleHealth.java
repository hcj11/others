package com.Domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by hcj on 18-7-18
 */
@Setter
@Getter
@ToString
public class FeMaleHealth extends User implements Serializable{
  public static final long serialVersionUID = 42L;
  private Integer id;
  private String common;
  private String special;

}
