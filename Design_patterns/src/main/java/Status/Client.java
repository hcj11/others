package Status;
/**
 * Created by hcj on 18-7-9
 */
public class Client {
    public   static  void main(String[] args){
      Context context = new Context();
      context.setLiftState(Context.closeState);
      context.open();
      context.close();
      context.run();
      context.stop();
    }
}
