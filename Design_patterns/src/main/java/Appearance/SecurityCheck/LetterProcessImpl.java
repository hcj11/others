package Appearance.SecurityCheck;

/**
 * Created by hcj on 18-7-8
 */
public class LetterProcessImpl implements ILetterProcess {

  @Override
  public void writeContext(String context) {
      System.out.println("写信的内容: "+context);
  }

  @Override
  public void fillEnvelope(String address) {
    System.out.println("信的目的地: "+address);
  }

  @Override
  public void letterIntoEnvelope() {
    System.out.println("信件放到信封里");
  }

  @Override
  public void sendLetter() {
    System.out.println("发送信....");
  }
}
