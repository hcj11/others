package Prototype.CommonSendMail;

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



}
