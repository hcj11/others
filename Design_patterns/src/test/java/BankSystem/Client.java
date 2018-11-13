package BankSystem;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

/**
 * 银行扣款子模块系统 的架构 用到的设计模式 1. Created by hcj on 18-7-12
 */
//@Slf4j
public class Client {

  //  private static Logger logger = Logger.getLogger(Client.class.getName());
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {

    // 通过门面调用  ,场景类不涉底层对象
    DeductionFacade deductionFacade = new DeductionFacade();
    Card card = new Card(1110, 1000, 100);
    int i = RandomUtils.nextInt(1000, 10000);
    Trade trade = new Trade(i, 10);

    deductionFacade.Action("abc", card, trade);
//      logger.info("{},{}",card,trade);
    log.info("哈哈哈 {},{}", card, trade);

    deductionFacade.Action("abc1", card, trade);
    log.info("哈哈哈 {},{}", card, trade);

//      System.out.println(card);
//    System.out.println(trade);

  }
}
