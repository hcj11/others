package base;

/**
 * Created by hcj on 18-7-6
 */
public class baseTest2 {
    public   static  void main(String[] args){
      String s1="哈";
      String s2="哈";
      String s3="哈哈";
      String s4 = s1 + s2;
      System.out.println(s4);
      // s3 ==s4 比较的是 string池中的数据
      System.out.println(s3==s4);
      s4=(s1+s2).intern();
      System.out.println(s3==s4);


    }

}
