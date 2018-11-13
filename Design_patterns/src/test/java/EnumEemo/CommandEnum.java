package EnumEemo;

/**
 * Created by hcj on 18-7-12
 */
public enum CommandEnum {
  ls("ha"), lss("ds");

  private CommandEnum(String value) {
    this.value = value;
  }

  private String value;

  public String getValue() {
    return this.value;
  }
    public   static  void main(String[] args){
      System.out.println(ls.getValue());
      System.out.println(lss.getValue());
    }

}
