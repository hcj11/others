package Concurrent.Test;

/**
 * Created by hcj on 18-5-25
 */
public class lineAndCols {
  public static void main(String[] args) {
    int[][] arr1 = new int[4][5];
    int[][] arr2 = new int[5][4];
    int temp = 0;
    //二维数组赋值
    for(int i=0;i<4;i++){
      for(int j=0;j<5;j++){
        temp++;
        arr1[i][j] = temp;
      }
    }
    //循环打印二维数组
    for(int i=0;i<4;i++){
      for(int j=0;j<5;j++){
        System.out.print(arr1[i][j] + "   ");
      }
      System.out.println();
    }
    System.out.println("======================================");
    //M行N列的矩阵交换行和列
    for(int i=0;i<4;i++){
      for(int j=0;j<5;j++){
        arr2[j][i] = arr1[i][j];
      }
    }
    //打印交换后的矩阵
    for(int i=0;i<5;i++){
      for(int j=0;j<4;j++){
        System.out.print(arr2[i][j] + "   ");
      }
      System.out.println();
    }
  }
}
