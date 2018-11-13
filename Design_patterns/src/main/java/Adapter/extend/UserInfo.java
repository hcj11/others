package Adapter.extend;

/**
 * Created by hcj on 18-7-8
 */
public class UserInfo implements IUserInfo {

  @Override
  public String getUserName() {
    return null;
  }

  @Override
  public String getHomeAddress() {
    return "泽库镇";
  }

  @Override
  public String getMobileNumber() {
    return null;
  }

  @Override
  public String getOfficeTelNumber() {
    return null;
  }

  @Override
  public String getHomeTelNumber() {
    return null;
  }
}
