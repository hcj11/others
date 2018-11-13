package BaseExercise.FileFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 文件过滤器 Created by hcj on 18-8-8
 */
public class FileFilterDemo {

  /** */
  public static void main(String[] args) {
    File file = new File("/home/hcj/rdm");

    FilenameFilter filenameFilter = new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        // 遍历文件
        String compile=".+";
        return Pattern.compile(compile).matcher(name).matches();
      }
    };
    String[] list = file.list(filenameFilter);
    // 忽略大小写
    Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);

    System.out.println(Arrays.toString(list));
  }

}
