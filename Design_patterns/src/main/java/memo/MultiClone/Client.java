package memo.MultiClone;

/**
 * BeanInfo 的备忘录模式 严格设置map的上限
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      Originator originator = new Originator();
      originator.setState1("1");
      originator.setState2("2");
      originator.setState3("3");
      System.out.println(originator.toString());
      Memento memento = originator.createMemento();
      originator.setState1("4");
      originator.setState2("5");
      originator.setState3("6");
      System.out.println(originator.toString());
      originator.restoreMemento(memento);
      System.out.println(originator.toString());


    }
}
