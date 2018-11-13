package Adapter.extend;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hcj on 18-7-8
 */
public class OuterUserBaseInfo implements IOuterUserBaseInfo {

  @Override
  public Map getUserBaseInfo() {
    HashMap<String,String> objectHashMap = new HashMap<>();
    objectHashMap.put("username","");
    return objectHashMap;
  }



}
