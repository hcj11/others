package Concurrent.question2.finishCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConcurrentHarness {

  static Writer fastestoutput;
  static Writer slowestoutput;
  static Writer averageoutput;

  // 最快 [common[第一次,2,3,4],semapsore[1,2,3,4]]
  static List<List<Long>> fastList; // 顺序是定死的
  // 最慢
  static List<List<Long>> slowList;
  // 平均
  static List<List<Long>> averageList;


  // 原来最快 [第一次[1,2,3,4,5],第二次[1,2,3,4,5]]
  static List<Long> initfastList; // 顺序是定死的

  //  static List<List<Long>> initfastLists; // 顺序是定死的
  // 原来最慢
  static List<Long> initslowList;
  // 原来平均
  static List<Long> initaverageList;


  static List<String> initList;

  static {
    try {
      fastestoutput = new FileWriter(new File("fastest.txt"));
      slowestoutput = new FileWriter(new File("slowest.txt"));
      averageoutput = new FileWriter(new File("average.txt"));

      fastList = new ArrayList<>();
      slowList = new ArrayList<>();
      averageList = new ArrayList<>();

      initList = new ArrayList<>();
      initfastList = new ArrayList<>();
      initslowList = new ArrayList<>();
      initaverageList = new ArrayList<>();

      initList.add("barriers");
      initList.add("phasers");
      initList.add("exchangers");
      initList.add("synchronsQueue");

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args)
      throws InstantiationException, IllegalAccessException, IOException {

    ConcurrentHarness concurrentHarness = new ConcurrentHarness();
    concurrentHarness.test();

  }

  public void test() throws IllegalAccessException, InstantiationException, IOException {
    barriers barriers = new barriers(10, 200, 11);
    phasers phasers = new phasers(10, 200, 11);
    exchangers exchangers = new exchangers(10, 200, 11);
    SynchronsQueueCode synchronsQueueCode = new SynchronsQueueCode(10, 200, 11);

    int count =10;
    for (int i = 1; i <= count; i++) {

      List<Long> barriers1 = measurePerf(barriers::test,
          barriers, "barriers  done in: ");
      initfastList.add(barriers1.get(0)); // [[1,2,3,4],[]]
      initslowList.add(barriers1.get(1));
      initaverageList.add(barriers1.get(2));

      List<Long> phasers1 = measurePerf(phasers::test,
          phasers, "phasers  done in: ");
      initfastList.add(phasers1.get(0));
      initslowList.add(phasers1.get(1));
      initaverageList.add(phasers1.get(2));

      List<Long> stringLongMap = measurePerf(exchangers::test,
          exchangers, "exchangers  done in: ");
      initfastList.add(stringLongMap.get(0));
      initslowList.add(stringLongMap.get(1));
      initaverageList.add(stringLongMap.get(2));

      List<Long> stringLongMap1 = measurePerf(
          synchronsQueueCode::test,
          synchronsQueueCode, "synchronsQueueCode  done in: ");
      initfastList.add(stringLongMap1.get(0));
      initslowList.add(stringLongMap1.get(1));
      initaverageList.add(stringLongMap1.get(2));

    }

    // 原来最快 [第一次[common,semapsore,],第二次[common,semapsore]]
    // 最快 [common[第一次,2,3,4],semapsore[1,2,3,4]]
    // 将 [[1,2,3,4]] => [[1,2,3,4],[]]  算法-> 每一行
    List<List> lists = new ArrayList<>();
    List<List> listslow = new ArrayList<>();
    List<List> listaverage = new ArrayList<>();

    integrateData(lists,initfastList);
    integrateData(listslow,initslowList);
    integrateData(listaverage,initaverageList);

    dataSum(lists,"fastest");
    dataSum(listslow,"slowest");
    dataSum(listaverage,"average");

  }

  /** 整合数据
   * Created by hcj on 18-5-27.
   */
  private void integrateData(List<List> lists,List<Long> initfastList) {
    int count = 0;
    for (int i = 0; i < 4; i++) { // 0-3
      count = i;
      List<Long> ids = new ArrayList<>();

      // 根据行号获取对应的数据 0-9 // 第1组的结果
      ids.add(initfastList.get(i));
      for (int j = 1; j < 10; j++) {//第2-10组的结果
        count += 4;
        // 0,9,18,27,36 ...   10组实验
        // 1,10,19,28..        10组实验
        // 2.. 9个实现方式
        Long aLong = initfastList.get(count);
        ids.add(aLong);
      }
      lists.add(ids);
    }
  }

  public static <T> List<Long> measurePerf(Consumer<T> f, T input, String ss) {
    // 分区追加到每个文件下
    List<Long> all = new ArrayList<>();

    long sum = 0;
    long fastest = Long.MAX_VALUE;
    long slowest = Long.MIN_VALUE;
    int count = 10; // 20 万次循环
    for (int i = 0; i < count; i++) {
      long start = System.nanoTime();
      f.accept(input);
      long duration = (System.nanoTime() - start) / 1_000_000;
      sum += duration;
      if (duration < fastest) {
        fastest = duration;
      }
      if (duration > slowest) {
        slowest = duration;
      }
    }
    all.add(fastest);
    all.add(slowest);
    all.add(sum / count);

    System.out.println(ss + ": fastest: " + fastest + " msecs");
    System.out.println(ss + ": slowest: " + slowest + " msecs");
    System.out.println(ss + ": average: " + sum / count + " msecs");
    return all;
  }

  private static void dataSum(List<List> lists,String type) throws IOException {
    StringBuilder stringBuilder = new StringBuilder(8196);

    StringBuilder stringBuilder2 = new StringBuilder(8196);
    StringBuilder append3 = new StringBuilder(8196);
    StringBuilder append = stringBuilder.append("").append(type).append(",").append("1,2,3,4,5,6,7,8,9,10");

    int count = 0;
    for (List list : lists) {
      String s = initList.get(count++);
      stringBuilder2.append("\n").append(s).append(",");
      for (Object longs : list) {

        stringBuilder2.append((Long) longs).append(",");
      }
      stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
    }
    append3.append(append).append(stringBuilder2);

    FileWriter fileWriter = new FileWriter(new File(""+type+".txt"));
    fileWriter.write(append3.toString());
    fileWriter.flush();
    fileWriter.close();

  }

//  public static <T, U> void measurePerfByPrivateExecutor(BiConsumer<T, U> f, T input, String ss,
//      U u) {
//    long sum = 0;
//    long fastest = Long.MAX_VALUE;
//    for (int i = 0; i < 10; i++) {
//      long start = System.nanoTime();
//      f.accept(input, u);
//
//      long duration = (System.nanoTime() - start) / 1_000_000;
//      sum += duration;
//      if (duration < fastest) {
//        fastest = duration;
//      }
//    }
//    System.out.println(ss + ": fastest: " + fastest + " msecs");
//    System.out.println(ss + ": average: " + sum / 10 + " msecs");
//  }

}