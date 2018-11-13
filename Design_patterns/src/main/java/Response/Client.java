package Response;

import java.util.Random;

/**
 * 责任链模式
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
      // 还是个女儿
      Handler father = new Father();
      Handler husBand = new Husband();
      Handler son = new Son();
      // 定义调用链
      father.setNext(husBand);
      husBand.setNext(son);

      for (int i=0;i<4;i++){
        Random random = new Random();
        int i1 = random.nextInt(4);
        IWomen women = new Women("我要出去玩!!!",i1);
        father.HandlerMessage(women);
      }






    }
}
