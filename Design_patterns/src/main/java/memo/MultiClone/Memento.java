package memo.MultiClone;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
public class Memento {
  private HashMap<String,Object> stateMap;
  public Memento( HashMap<String,Object> stateMap){
    this.stateMap=stateMap;
  }
}
