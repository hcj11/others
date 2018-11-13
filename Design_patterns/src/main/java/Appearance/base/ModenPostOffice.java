package Appearance.base;


/**
 * Created by hcj on 18-7-8
 */
public class ModenPostOffice {

  private ILetterProcess iLetterProcess = new LetterProcessImpl();


  // 你把信给我,我给你寄,   顺便附带上地址和内容就可以了
  public void sendLetter(String context, String address) {
    iLetterProcess.writeContext(context);
    iLetterProcess.fillEnvelope(address);
    iLetterProcess.letterIntoEnvelope();
    iLetterProcess.sendLetter();
  }

}
