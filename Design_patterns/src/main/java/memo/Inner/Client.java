package memo.Inner;


/**
 * 使用内部类,保存数据的私有 Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    /**
     * 对于其他子系统无法获取该对象信息,  已经封装到内部类中,只能有父类 去访问,
     双接口设计, 增加安全性
     */
    Boy boy = new Boy();
    boy.setState("心情很好!!!");
    System.out.println(boy.getState());
    IMemento memento = boy.createMemento();
    // caretaker -> 备忘录管理者
    Caretaker caretaker = new Caretaker();
    caretaker.setMemento(memento);
    // 保存心情
    boy.changeState();
    boy.restoreMemento(caretaker.getMemento());
    System.out.println(boy.getState());


  }
}
