package Adapter.extend;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hcj on 18-7-8
 */
public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {

  @Override
  public Map getUserOfficeInfo() {
    HashMap<String,String> objectHashMap = new HashMap<>();
    objectHashMap.put("officeTelNumber","86-8787725");
    return objectHashMap;
  }
}
