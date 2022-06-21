// プログラム1-6: ２ｘ２行列の逆行列を求めるプログラム　

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class InverseMatrixTest {
  public static void main(String[] args) {
    double t; // 判別式の値を保持
    double[][] matrix        = new double[2][2];
    double[][] inverseMatrix = new double[2][2];

    try {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader    br  = new BufferedReader(isr);

      String[] result = null;
      String s;

      System.out.print("2x2行列の1行目の要素を入力してください。>");
      // C言語でのscanf("%lf%lf", &matrix[0][0], &matrix[0][1]);に相当
      s = br.readLine();
      result = s.split("\\s+");
      matrix[0][0] = Double.valueOf(result[0]).doubleValue();
      matrix[0][1] = Double.valueOf(result[1]).doubleValue();

      System.out.print("2x2行列の2行目の要素を入力してください。>");
      s = br.readLine();
      result = s.split("\\s+");
      matrix[1][0] = Double.valueOf(result[0]).doubleValue();
      matrix[1][1] = Double.valueOf(result[1]).doubleValue();

      System.out.print("入力された行列は以下の通りです\n");
      s = String.format("    [ %f %f ]\n", matrix[0][0], matrix[0][1]);
      System.out.print(s);
      s = String.format("    [ %f %f ]\n", matrix[1][0], matrix[1][1]);
      System.out.print(s);

      // 判別式の計算
      t = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
      if (t == 0.0) {
        System.err.print("判別式が0であり，逆行列は存在しません。\n");
        return;
      }

      // 逆行列の計算
      t = 1.0 / t;
      inverseMatrix[0][0] =  t * matrix[1][1];
      inverseMatrix[0][1] = -t * matrix[0][1];
      inverseMatrix[1][0] = -t * matrix[1][0];
      inverseMatrix[1][1] =  t * matrix[0][0];

      System.out.print("入力された行列の逆行列は以下の通りです\n");
      s = String.format("    [ %f %f ]\n", inverseMatrix[0][0], inverseMatrix[0][1]);
      System.out.print(s);
      s = String.format("    [ %f %f ]\n", inverseMatrix[1][0], inverseMatrix[1][1]);
      System.out.print(s);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
