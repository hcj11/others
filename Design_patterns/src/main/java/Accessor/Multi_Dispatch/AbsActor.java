package Accessor.Multi_Dispatch;

/**
 * Created by hcj on 18-7-8
 */
public abstract class AbsActor {

  public void act(Role role) {
    System.out.println("演员可以扮演任何角色");
  }

  public void act(KungFunRole role) {
    System.out.println("演员都可以扮演功夫角色");
  }


}
