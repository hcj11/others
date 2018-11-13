package Concurrent.Test;

import com.mshuoke.datagw.conf.utils.ExecutorsUtil;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/**
 * 并发文件写入 Created by hcj on 18-7-4
 */
public class ConcurrenctFileWirte {

  // 做线程池的监控操作
  private static final ExecutorService executorService = ExecutorsUtil
      .newFixedThreadPool(3, "single");

  public static void main(String[] args) {

    // 同时写入
    for(int i=0;i<3;i++){
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          writeData();
        }
      });
    }
    // 关闭线程池
    executorService.shutdown();

  }
//  public static void writeData() {
//    BufferedWriter bufferedWriter = null;
//    try {
//      // 数据同时写入是没有问题的,只生成了一份文件,但是顺序是无法保证,
//      // 那么同时生成文件到指定文件夹中?
//      // 根目录下面
//      bufferedWriter = new BufferedWriter(new FileWriter("./output.log",true));
//      bufferedWriter.write("hello world!!!");
//      bufferedWriter.newLine();
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    } finally {
//      try {
//        Objects.requireNonNull(bufferedWriter).close();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//  }

  public static void writeData() {
    BufferedWriter bufferedWriter = null;
    try {
      // 数据同时写入是没有问题的,只生成了一份文件,但是顺序是无法保证,
      // 那么同时生成文件到指定文件夹中?
      // 根目录下面
      bufferedWriter = new BufferedWriter(new FileWriter("./output.log",true));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bufferedWriter.write("hello world!!!");
      bufferedWriter.newLine();

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        Objects.requireNonNull(bufferedWriter).close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


}
