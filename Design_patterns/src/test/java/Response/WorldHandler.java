package Response;


/**
 * 全国处理器
 * Created by hcj on 18-7-12
 */
public class WorldHandler extends Handler {

  @Override
  public Record response(String domain) {
    Record record = new Record();
    record.setDns("世界DNS服务器");
    record.setIp(super.getIpAddress());
    record.setDomain(domain);
    return record;
    // 打印该ip对应的域名
//    System.out.println("世界dns可以解析到为,www.hi.org" );

  }
  @Override
  public boolean isLocal(String ip) {
      return true;
  }
}
