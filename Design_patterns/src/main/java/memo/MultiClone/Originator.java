package memo.MultiClone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-8
 */
@Getter
@Setter
@ToString
public class Originator {
    private String state1;
    private String state2;
    private String state3;
    public Memento createMemento(){
      return new Memento(BeanUtils.backupProp(this));
    }
    public void restoreMemento(Memento memento){
        BeanUtils.restoreProp(this,memento.getStateMap());
    }

}
