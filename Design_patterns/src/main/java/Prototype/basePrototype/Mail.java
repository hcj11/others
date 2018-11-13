package Prototype.basePrototype;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-7
 */
@Getter
@Setter
public class Mail implements Cloneable {

  // 收信人
  private String receiver;
  private String subject;
  private String advContext;
  private String application;
  private String tail;

  public Mail() {
  }

  private AdvTemplate advTemplate;

  public Mail(AdvTemplate advTemplate) {
    this.advTemplate = advTemplate;
  }

  public  Mail clone() {
    Mail mail=null;
    try {
      return (Mail)super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }


}
