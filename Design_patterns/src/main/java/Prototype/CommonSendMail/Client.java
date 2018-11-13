package Prototype.CommonSendMail;

/**
 *  原型模式  ,拷贝指定对象实例
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      // 发送邮件
      int count=6;
      AdvTemplate advTemplate = new AdvTemplate();
      for (int i=0;i<count;i++){
        Mail mail = new Mail(advTemplate);
        mail.setReceiver("收信人: 天堂"+i);
        mail.setApplication("寄信人: 地狱"+i);
        sendMail(mail);
      }

    }

  /**
   * 发送邮件
   * Created by hcj on 18-7-7.
   */
  private static void sendMail(Mail mail) {
    System.out.println("银行发送信息中..."+mail.getReceiver()+":"+mail.getApplication()+" , 内容如下: "+mail.getAdvTemplate().getAdvContext());
  }
}
