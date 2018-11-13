package spittr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "mailServer", ignoreUnknownFields = false)
public class MailServerProperties {

  private  String[] to;
  private  String  from;
  private String backupfile;

  public String getBackupfile() {
    return backupfile;
  }

  public void setBackupfile(String backupfile) {
    this.backupfile = backupfile;
  }

  public String[] getTo() {
    return to;
  }

  public void setTo(String[] to) {
    this.to = to;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }
}
