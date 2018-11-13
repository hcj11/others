package memo.extend;


/**
 * 备忘录模式
 * 注意事项
 * 1. 备忘录的生命期
 *    主动管理它的生命周期,不用时,立刻删除
 * 2. 备忘录的性能
 *    不要在频繁建立备份的场景下使用备忘录模式, 1.无法控制备忘录的数量,2大对象的建立耗费资源
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
      caretaker.setMemento(memento);
      // 保存心情
      boy.changeState();
      boy.restoreMemento(caretaker.getMemento());
      System.out.println(boy.getState());

    }
}
