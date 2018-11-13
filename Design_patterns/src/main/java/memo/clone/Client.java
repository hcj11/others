package memo.clone;

/**
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      Boy boy = new Boy();
      boy.setState("心情很好!!!");
      System.out.println(boy.getState());
      Boy memento = boy.createMemento();
      // 保存心情
      boy.changeState();
      boy.restoreMemento(memento);
      System.out.println(boy.getState());
    }
}
