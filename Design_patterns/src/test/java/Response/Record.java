package Response;

import lombok.Getter;
import lombok.Setter;

/**
 * 中间变量
 * Created by hcj on 18-7-12
 */
@Setter
@Getter
public class Record {
  private String dns;
  private String ip;
  private String domain;

  @Override
  public String toString() {
    StringBuilder sb =new StringBuilder(8196);
    sb.append("域名是: ").append(this.getDomain()).append("\n")
        .append("ip地址"+this.getIp()).append("\n").append("dns是: "+this.getDns());

    return sb.toString();
  }
}
