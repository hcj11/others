package Singleton;

import java.util.ArrayList;
import java.util.Random;

/**
 * 皇帝 Created by hcj on 18-7-6
 */
public class Emperor {

  // 上限
  private static int maxNumOfEmperor = 2;
  // 定义皇帝名称 静态安全发布
  private static ArrayList<String> strlist = new ArrayList<String>();
  // 定义皇帝实例 静态安全发布
  private static ArrayList<Emperor> emperors = new ArrayList<Emperor>();
  private static  int countNumofEmporer=0;

  static {
    // 构建皇帝对象
    for (int i = 1; i < maxNumOfEmperor + 1; i++) {
      emperors.add(new Emperor("emporers" + i));
    }
  }

  private Emperor() {
  }

  private Emperor(String name) {
    strlist.add(name);
  }

  public static Emperor getInstance() {
    // 随机选择一个皇帝出来
    Random random = new Random();
    int countNumofEmporer = random.nextInt(2);// 0,1
    return emperors.get(countNumofEmporer);
  }

   static void say() {
      System.out.print(strlist.get(countNumofEmporer));
  }

  /**
   * 大臣
   */
  class Minister {
    public void get(){
      // 内部类同样可以调用public类的private数据
      System.out.println(maxNumOfEmperor);
    }
  }
}
