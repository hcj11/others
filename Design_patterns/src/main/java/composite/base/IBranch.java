package composite.base;

import java.util.ArrayList;

/**
 * Created by hcj on 18-7-8
 */
public interface IBranch extends ICorp{
  public void add(ICorp corp);
  public ArrayList getSuborinateInfo();

}
