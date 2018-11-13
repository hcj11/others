package memo.MultiStatus;


/**
 * 对于一个发起人,备份多份数据, 保存的数据标志唯一即可.
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      Boy boy = new Boy();
      boy.setState("心情很好!!!");
      System.out.println(boy.getState());
      Memento memento = boy.createMemento();
      // caretaker -> 备忘录管理者
      Caretaker caretaker = new Caretaker();
//      caretaker.setMemento(memento);
      caretaker.put("001",memento);

      caretaker.put("002",memento);
      // 保存心情
      boy.changeState();
      boy.restoreMemento(caretaker.get("002"));
      System.out.println(boy.getState());

    }
}
