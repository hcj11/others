package Concurrent.Deadlock;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-5-6
 */
@Getter
@Setter
public class DollarAmount implements Comparable {

  private Integer amount;

  public DollarAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public int compareTo(Object o) {
    DollarAmount o1 = (DollarAmount) o;
    return this.amount - o1.amount > 0 ? 1 : -1;
  }
}
