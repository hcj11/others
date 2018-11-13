package Agent;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Setter
@Getter
public abstract class AbstractMediator {

  protected Purchase purchase;
  protected Sale sale;
  protected Stock stock;

  public AbstractMediator() {
    this.purchase=new Purchase(this);
    this.sale=new Sale(this);
    this.stock=new Stock(this);
  }

  public  abstract  void execute(String str, Object... obj);
}
