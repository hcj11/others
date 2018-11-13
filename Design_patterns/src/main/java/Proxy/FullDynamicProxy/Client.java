package Proxy.FullDynamicProxy;

/**
 * Created by hcj on 18-7-7
 */
public class Client {
    public   static  void main(String[] args){
      // 动态代理
      Subject subject = new RealSubject();
      Subject subjectProy = (Subject) SubjectDynamicProxy.newInstance(subject);
      subjectProy.doSomething();

    }
}
