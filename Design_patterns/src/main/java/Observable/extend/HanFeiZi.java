package Observable.extend;

import java.util.Observable;

/**
 * Created by hcj on 18-7-8
 */
public class HanFeiZi extends Observable implements IHanFeiZi {


  @Override
  public void haveBreakfast() {
    super.setChanged();
    // 触发更新操作. 通知观察者
    super.notifyObservers("HanFeiZi 在吃饭");


  }

  @Override
  public void haveFun() {
    super.setChanged();
    super.notifyObservers("HanFeiZi 在happy");
  }

}
