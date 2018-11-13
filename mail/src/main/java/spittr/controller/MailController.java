package spittr.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spittr.config.MailServerProperties;

/**
 * Created by hcj on 18-3-7
 */
@RequestMapping("/mail")
@RestController
public class MailController {

  @Autowired
  JavaMailSenderImpl mailSender;
  @Autowired
  MailServerProperties mailServerProperties;


  @PostMapping("sendMail")
  public ResponseEntity copyFile(
      @RequestParam(value = "file") MultipartFile file,
      @RequestParam(value = "provider_name") String provider_name
  ) throws IOException {
    // 流文件 磁盘化,替换操作 当前路径下
    // 取别名
    UUID uuid = UUID.randomUUID();
    String uuidstr = uuid.toString();
    String originalFilename = file.getOriginalFilename();
    // 对文件进行编码?
    String extendsion = originalFilename.substring(originalFilename.indexOf("."));

    String allFile = mailServerProperties.getBackupfile() + uuidstr + extendsion; // uuid.xlsx

    file.transferTo(new File(allFile));

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = null;
    try {
      // 开vpn无法使用
      helper = new MimeMessageHelper(message, true);
      helper.setFrom(mailServerProperties.getFrom());
      // "Tom.hou@mso-china.com"
      helper.setTo(mailServerProperties.getTo()); // 2018-06-28
      String format = new SimpleDateFormat("yyyy-MM-dd")
          .format(new Date());
      helper.setSubject("行为数据_" + provider_name + "_" + format);
      helper.setText("详细情况请看附件");
      // 获取流信息
      helper.addAttachment("CSJ入库数据每日反馈报告.xlsx", new File(allFile));

    } catch (MessagingException e) {
      e.printStackTrace();
    }
    mailSender.send(message);

    return ResponseEntity.ok("sendMail,ok");
  }


}