package Adapter.extend;

import java.util.HashMap;

/**
 * Created by hcj on 18-7-8
 */
public class OuterUserInfo implements IUserInfo {

  // 员工基本信息 ,todo 通过构造器进行初始化
  private OuterUserBaseInfo outerUserBaseInfo = new OuterUserBaseInfo();
  private OuterUserHomeInfo outerUserHomeInfo = new OuterUserHomeInfo();
  private OuterUserOfficeInfo outerUserOfficeInfo = new OuterUserOfficeInfo();


  @Override
  public String getUserName() {
    HashMap<String, String> username = (HashMap<String, String>) this.outerUserBaseInfo
        .getUserBaseInfo();
    return username.get("username");

  }

  @Override
  public String getHomeAddress() {
    HashMap<String, String> username = (HashMap<String, String>) this.outerUserHomeInfo
        .getUserHomeInfo();
    return username.get("homeAddress");
  }

  @Override
  public String getMobileNumber() {
    return null;
  }

  @Override
  public String getOfficeTelNumber() {
    HashMap<String, String> username = (HashMap<String, String>) this.outerUserOfficeInfo
        .getUserOfficeInfo();
    return username.get("officeTelNumber");
  }

  @Override
  public String getHomeTelNumber() {
    return null;
  }
}
