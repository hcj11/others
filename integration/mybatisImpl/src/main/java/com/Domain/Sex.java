package com.Domain;

/**
 * Created by hcj on 18-7-18
 */
public enum Sex {
  // 初始化对象
  FEMALE(0, "男"), MALE(1, "女");
  private int i;
  private String value;

  Sex(int i, String value) {
    this.i = i;
    this.value = value;
  }

  public int getSex() {
    return i;
  }

  public String getValue(int i) {
    if (i == 0) {
      return FEMALE.value;
    } else {
      return MALE.value;
    }
  }

}
