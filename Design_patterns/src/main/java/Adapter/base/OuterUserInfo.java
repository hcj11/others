package Adapter.base;

import java.util.Map;

/**
 * Created by hcj on 18-7-8
 */
public class OuterUserInfo extends  OuterUser implements IUserInfo  {
  // 员工基本信息
  private Map userBaseInfo = super.getUserBaseInfo();
  private Map userOfficeInfo = super.getUserOfficeInfo();
  private Map userHomeInfo = super.getUserHomeInfo();

  @Override
  public String getUserName() {
    Object username = this.userBaseInfo.get("username");
    return String.valueOf(username);
  }

  @Override
  public String getHomeAddress() {
    Object username = this.userHomeInfo.get("homeAddress");
    return String.valueOf(username);
  }

  @Override
  public String getMobileNumber() {
    return null;
  }

  @Override
  public String getOfficeTelNumber() {
    Object username = this.userOfficeInfo.get("officeTelNumber");
    return String.valueOf(username);
  }

  @Override
  public String getHomeTelNumber() {
    return null;
  }
}
