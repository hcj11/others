package memo.clone;

/**
 * Created by hcj on 18-7-8
 */
public class Boy implements Cloneable {
  // 备份
//  private Boy backup;
  private String state;

  public void changeState() {
    System.out.println("见女孩后,心情不好");
    setState("心情不好");
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Boy createMemento() {
    // 保存当时的状态
    Boy clone = (Boy) this.clone();
    // 自主备份
//    this.backup=clone;
    return clone;
  }

  public void restoreMemento(Boy boy) {
    this.setState(boy.getState());
  }

  @Override
  protected Object clone() {
    try {
      return (Boy) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }
}
