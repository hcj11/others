package Appearance.SecurityCheck;

/**
 * Created by hcj on 18-7-8
 */
public interface ILetterProcess {
  public void writeContext(String context);
  // 外面添上地址
  public void fillEnvelope(String address);
  // 信件放到信封里
  public void letterIntoEnvelope();
  public void sendLetter();


}
