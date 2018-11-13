package LockQuestion;

import Concurrent.Synchronized.SynchronizedDemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hcj on 18-6-6
 */
@Getter
@Setter
public class WordsFinder {

  private static StringBuilder sb = new StringBuilder(8196);
  private static ArrayList<String> list = new ArrayList<String>();
  private List<Thread> lists = new LinkedList<>();
  private static int size = 0;

 static {
    String ss = "For too long a small group in our nation's capital has reaped "
        + "the rewards of government while the people have borne the cost "
        + "Washington flourished but the people did not share in its wealth "
        + "Politicians prospered but the jobs left And the factories closed ";
    String[] split = ss.split(" ");
    List<String> strings = Arrays.asList(split);
    list.addAll(strings);
    size = list.size();
  }


  public static void main(String[] args) {
    WordsFinder wordsFinder = new WordsFinder();
    WordsFinderWithNoSyncMain(wordsFinder);
  }

  public static void WordsFinderWithNoSyncMain(WordsFinder wordsFinder) {
    wordsFinder.threadStart();
    // 线程等待死亡
    for (Thread thread : wordsFinder.getLists()) {
      try {
        thread.join(); // timeout=0s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // 打印结果
    System.out.println(sb.toString());
//    int length = sb.toString().split(" ").length;
//    System.out.println(length);
//    System.out.println(sb.capacity());
//    if (commonDemo.getCount() != 55) {
//      System.out.println("Result: " + commonDemo.getCount());
//    }
  }

  public void threadStart() {
    lists.clear();
    // 开启10个线程
    for (int i = 1; i <= 10; i++) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          dataAppend();
        }
      });
      thread.start();
      lists.add(thread);
    }

  }

  public void dataAppend() {
    // 随机获取 [0,1) -> [0,30)
    for (int i = 0; i < 1000; i++) {
      int random = (int) (Math.random() * size);
      sb.append(list.get(random)).append(" ");
    }
  }

}
