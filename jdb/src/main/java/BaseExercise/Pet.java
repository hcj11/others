package BaseExercise;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-29
 */
@Setter
@Getter
@ToString
public class Pet {
  private Integer id;

  public Pet(int i) {
    this.id=i;

  }
}
