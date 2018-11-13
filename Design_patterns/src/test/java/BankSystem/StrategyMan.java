package BankSystem;

/**
 * Created by hcj on 18-7-12
 */
public enum  StrategyMan {
  FreeDeduction("BankSystem.FreeDeduction"),
  SteadyDeduction("BankSystem.SteadyDeduction");
  private String value;
  private StrategyMan(String value){
    this.value=value;
  }
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
