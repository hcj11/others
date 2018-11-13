package memo.extend;

/**
 * Created by hcj on 18-7-8
 */
public class Boy {
  private String state;
  public void changeState(){
      System.out.println("见女孩后,心情不好");
      setState("心情不好");
  }
  public String getState(){
    return this.state;
  }
  public void setState(String state){
    this.state=state;
  }
  public Memento createMemento(){
      // 保存当前状态
    Memento memento = new Memento();
    memento.setState(this.state);
    return memento;
  }
  public void restoreMemento(Memento _memento){
    this.setState(_memento.getState());
  }

}
