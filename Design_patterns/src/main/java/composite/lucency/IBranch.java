package composite.lucency;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-8
 */
public abstract class IBranch  {
  public abstract void add(IBranch corp);
  public abstract ArrayList<IBranch> getSuborinateInfo();
  public abstract String getInfo();

}
