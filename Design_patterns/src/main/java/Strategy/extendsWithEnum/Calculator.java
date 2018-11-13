package Strategy.extendsWithEnum;

/**
 * 策略枚举
 * Created by hcj on 18-7-8
 */
public enum Calculator {

  // 匿名类?
  ADD("+"){
    public int exec(int a,int b){
      return a+b;
    }

    @Override
    public String get() {
      return null;
    }
  },
  SUB("-"){
    public int exec(int a,int b){
      return a-b;
    }

    @Override
    public String get() {
      return null;
    }
  },
  VALUE("*"){
    @Override
    public int exec(int a, int b) {
      return 0;
    }

    public String get(){
      return getValue();
    }
  };

  String value="";
  private Calculator(String _value) {
    this.value=_value;
  }

  public String getValue() {
    return value;
  }
  public abstract int exec(int a,int b);
  public abstract String get();

    public   static  void main(String[] args){
      System.out.println(Calculator.VALUE.get());
    }
}
