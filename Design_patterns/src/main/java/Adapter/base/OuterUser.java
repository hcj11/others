package Adapter.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hcj on 18-7-8
 */
public class OuterUser implements IOuterUser {

  @Override
  public Map getUserBaseInfo() {
    HashMap<String,String> objectHashMap = new HashMap<>();
    objectHashMap.put("username","");
    return objectHashMap;
  }

  @Override
  public Map getUserOfficeInfo() {
    HashMap<String,String> objectHashMap = new HashMap<>();
    objectHashMap.put("officeTelNumber","86-8787725");
    return objectHashMap;
  }

  @Override
  public Map getUserHomeInfo() {
    HashMap<String,String> objectHashMap = new HashMap<>();
    objectHashMap.put("homeAddress","李子园");
    return objectHashMap;
  }
}
