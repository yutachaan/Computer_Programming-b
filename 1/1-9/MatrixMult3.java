// プログラム1-9: 行列の乗算例

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MatrixMult3 {
  public static void main(String[] args) {
    double[][] a = new double[2][2];
    double[][] b = new double[2][2];
    double[][] c = new double[2][2];

    try {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader    br  = new BufferedReader(isr);

      String[] result = null;
      String s;

      System.out.print("1: 2x2行列の1行目の要素を入力してください。>");
      s = br.readLine();
      result = s.split("\\s+");
      a[0][0] = Double.valueOf(result[0]).doubleValue();
      a[0][1] = Double.valueOf(result[1]).doubleValue();

      System.out.print("1: 2x2行列の2行目の要素を入力してください。>");
      s = br.readLine();
      result = s.split("\\s+");
      a[1][0] = Double.valueOf(result[0]).doubleValue();
      a[1][1] = Double.valueOf(result[1]).doubleValue();

      System.out.print("第1の入力された行列は以下の通りです\n");
      System.out.printf("    [ %f %f ]\n", a[0][0], a[0][1]);
      System.out.printf("    [ %f %f ]\n", a[1][0], a[1][1]);

      System.out.print("2: 2x2行列の1行目の要素を入力してください。>");
      s = br.readLine();
      result = s.split("\\s+");
      b[0][0] = Double.valueOf(result[0]).doubleValue();
      b[0][1] = Double.valueOf(result[1]).doubleValue();

      System.out.print("2: 2x2行列の2行目の要素を入力してください。>");
      s = br.readLine();
      result = s.split("\\s+");
      b[1][0] = Double.valueOf(result[0]).doubleValue();
      b[1][1] = Double.valueOf(result[1]).doubleValue();

      System.out.print("第2の入力された行列は以下の通りです\n");
      System.out.printf("    [ %f %f ]\n", b[0][0], b[0][1]);
      System.out.printf("    [ %f %f ]\n", b[1][0], b[1][1]);

      for (int i = 0; i < 2; i++) for (int j = 0; j < 2; j++) c[i][j] = 0.0;

      for (int i = 0; i < 2; i++) for (int j = 0; j < 2; j++) for (int k = 0; k < 2; k++) c[i][j] += a[i][k] * b[k][j];

      System.out.print("入力された2つの行列の積は以下の通りです\n");
      System.out.printf("    [ %f %f ]\n", c[0][0], c[0][1]);
      System.out.printf("    [ %f %f ]\n", c[1][0], c[1][1]);
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}
