package Strategy.extendsWithEnum;

/**
 * Created by hcj on 18-7-8
 */
public class Client {
    public   static  void main(String[] args){
//      System.out.println(args[1]);
//      int a= Integer.parseInt(args[0]);
//
//      int b= Integer.parseInt(args[1]);

       int a= 1;

       int b= 2;
       String symbol="+";
       System.out.println(Calculator.ADD.exec(a,b));
      System.out.println(Calculator.SUB.exec(a,b));

    }
}
