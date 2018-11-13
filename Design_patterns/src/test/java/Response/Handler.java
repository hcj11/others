package Response;


import java.util.Random;

/**
 * 责任链 ip地址 对应对应的 dns
 *
 * 地区 www.hi.com, 中国 www.hi.cn.com,全世界 www.hi.org Created by hcj on 18-7-12
 */
public abstract class Handler {

  private Handler nextHandler;
  // 初始化
  private Record record;

  public void setRecord(Record record) {
    this.record = record;
  }

  public Record getRecord() {
    return record;
  }

  public Handler getNextHandler() {
    return this.nextHandler;
  }

  private static Random random = new Random();

  public void setNextHandler(Handler nextHandler) {
    this.nextHandler = nextHandler;
  }

  // 处理任务
  public abstract Record response(String ip);

  // 处理任务
  public abstract boolean isLocal(String ip);

//  public Record echo(String domain) {
//    Record record = new Record();
//    record.setIp(getIpAddress());
//    record.setDomain(domain);
//    return record;
//  }

  // 根据地址寻找
  public final Record handlerRequest(String domain) {
    // 对ip地址进行解析 随机对应一个域名 0,1
    // 由子类实现校验逻辑 递归逻辑尽量简单,   递归容易糊涂
//    Record record=null;
    if (isLocal(domain)) {
      // 是该域名:
      return this.response(domain);
    } else {
      return this.nextHandler.handlerRequest(domain);
    }
  }

  public String getIpAddress() {

    return String.valueOf(random.nextInt(192)) + "." + random.nextInt(192) + "." + random
        .nextInt(192) + "." + random.nextInt(192);
  }

  public static void main(String[] args) {
    int i = random.nextInt(2);
    System.out.println(i);
  }

}
