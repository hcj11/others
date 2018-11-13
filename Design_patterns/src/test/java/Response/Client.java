package Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 责任链模式 Created by hcj on 18-7-12
 */
public class Client {

  public static void main(String[] args) {
    // 命令模式?  查询功能
    districtHandler districtHandler = new districtHandler();
    StateHandler stateHandler = new StateHandler();
    WorldHandler worldHandler = new WorldHandler();
    districtHandler.setNextHandler(stateHandler);
    stateHandler.setNextHandler(worldHandler);
    districtHandler.setRecord(new Record());
    stateHandler.setRecord(new Record());
    worldHandler.setRecord(new Record());

    // 从头链启动 根据域名继续ip地址
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      try {
        String s = bufferedReader.readLine();
        if (s.equalsIgnoreCase("n")){
          return;
        }
        Record record = districtHandler.handlerRequest(s);
        System.out.println(record);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}
