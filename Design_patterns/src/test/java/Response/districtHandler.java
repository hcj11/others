package Response;


/**
 * Created by hcj on 18-7-12
 */
public class districtHandler extends Handler {

  @Override
  public Record response(String domain) {
    Record record = new Record();
    record.setDns("上海DNS服务器");
    record.setIp(super.getIpAddress());
    record.setDomain(domain);
    // 打印该ip对应的域名
//    System.out.println("地区dns可以继续解析到为,www.hi.com" );
    return record;
  }

  @Override
  public boolean isLocal(String ip) {
    if(ip.endsWith(".com")){
      return true;
    }
    return false;
  }

}
