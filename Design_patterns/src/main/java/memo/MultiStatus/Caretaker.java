package memo.MultiStatus;

import java.time.Instant;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-7-8
 */
@Setter
@Getter
public class Caretaker {
  private Memento memento;
  private HashMap<String,Memento> map = new HashMap<String,Memento>();
  public void put(String idx,Memento memento){
    // 当前时间
    map.put(idx,memento);
  }

  public Memento get(String idx){
    // 当前时间
    return map.get(idx);
  }
}
