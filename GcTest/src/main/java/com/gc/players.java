package com.gc;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-3-5
 */
@Setter
@Getter
@ToString
@Builder
public class players {
    public players(){};
    private String name;
    private Boolean mvp;
    private Integer age;
    // 入职
    private Instant  onFireDate;

  public players(String name, Boolean mvp, Integer age, Instant onFire) {
    this.name = name;
    this.mvp = mvp;
    this.age = age;
    this.onFireDate = onFire;
  }
}
