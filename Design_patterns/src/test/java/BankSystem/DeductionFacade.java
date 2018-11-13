package BankSystem;

/**
 * Created by hcj on 18-7-12
 */
public class DeductionFacade {
  // 执行调用
  public void Action(String type,Card card,Trade trade){
    String deductionType = getDeductionType(type);
    IDeduction iDeduction = (IDeduction) StrategyFactory.buildStategy(deductionType);
    iDeduction.exec(trade,card);
  }

  private String getDeductionType(String type) {
    if(type.equalsIgnoreCase("abc")){
      return StrategyMan.FreeDeduction.getValue();
    }else{
      return StrategyMan.SteadyDeduction.getValue();
    }

  }
}
