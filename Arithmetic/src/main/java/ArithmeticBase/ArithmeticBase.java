package ArithmeticBase;

import java.util.Arrays;

/**
 * Created by hcj on 18-7-10
 */
public class ArithmeticBase {

  public static void main(String[] args) {
//    bubbleSort();
//    selectSort();
    int a[] = new int[]{1, 2, 5, 34};
//    int i = binSearch(a, 34);
    // 递归的高效查询
    int i = binSearch2(a, 0, 3, 34);
    System.out.println(i);

  }
  public static int binSearch2(int srcArray[], int start, int end, int key) {
    int mid = (end - start) / 2 + start;
    if (srcArray[mid] == key) {
      return mid; // 中断条件1
    }
    if (start >= end) { // 中断条件2
      return -1;
    } else if (key > srcArray[mid]) {
      return binSearch2(srcArray, mid + 1, end, key);
    } else if (key < srcArray[mid]) {
      return binSearch2(srcArray, start, mid - 1, key);
    }
    return -1;
  }

  public static int binSearch(int srcArray[], int key) {
    int mid;
    int start = 0;
    int end = srcArray.length - 1;
    while (start <= end) {
      mid = (end - start) / 2 + start;
      if (key < srcArray[mid]) {
        end = mid - 1;
      } else if (key > srcArray[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  // 选择排序
  public static void selectSort() {
    int a[] = new int[]{1, 2, 34, 5};
    int length = a.length;
    int min = 0;
    int temp = 0;
    // 每次循环查到最小的数 ,并与当前a[j] 进行交换顺序
    for (int i = 0; i <= length - 1; i++) {
      min = a[i]; // 取最小值
      for (int j = i + 1; j <= length - 1; j++) {
        if (min > a[j]) {
          // 赋值操作找到最小值 , 循环交换位子
          temp = min;
          min = a[j];
          a[j] = temp;
        }
      }
      // 把最终获取的最小值赋值给a[i]
      a[i] = min;
    }
    System.out.println(a);
  }

  // 冒泡排序
  public static void bubbleSort() {
    int a[] = new int[]{1, 2, 34, 5};
    int length = a.length;
    int var = 0;
    // 顺序
    for (int i = 1; i <= length; i++) {
      for (int j = i - 1; j < length - i; j++) {
        if (a[j] > a[j + 1]) {
          var = a[j];
          a[j] = a[j + 1];
          a[j + 1] = var;
        }
      }
    }

    System.out.println(Arrays.asList(a));

  }
}
