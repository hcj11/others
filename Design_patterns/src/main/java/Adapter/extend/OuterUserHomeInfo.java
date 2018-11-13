package Adapter.extend;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hcj on 18-7-8
 */
public class OuterUserHomeInfo implements IOuterUserHomeInfo {

  @Override
  public Map getUserHomeInfo() {
    HashMap<String,String> objectHashMap = new HashMap<>();
    objectHashMap.put("homeAddress","李子园");
    return objectHashMap;
  }
}
