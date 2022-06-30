/*
  行列のデータをファイルから読み込み，内容の表示，乗算，加算，減算をおこなう

  @作成者: 佐藤 優太
  @提出日: 2022/06/30

  % javacu Matrix.java
  % javau Matrix [ファイル名1] [ファイル名2] [ファイル名3]
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class Matrix {
  private BufferedReader br = null;
  private double[][] m; // 行列
  private int row, col; // row: 行サイズ， col: 列サイズ

  public Matrix() {
    this.m = null;
    this.row = 0; this.col = 0;
  }

  public Matrix(int M, int N) {
    this.m = new double[M][N];
    this.row = M; this.col = N;
  }

  // 自分の名前や学籍番号などの情報を出力する(file1, file2, file3: 入力ファイル名)
  public void printMyInfo(String file1, String file2, String file3) {
    System.out.print("******************************\n");
    System.out.print("名前: 佐藤 優太\n");
    System.out.print("学籍番号: B223330\n");
    System.out.print("提出日: 2022/06/30\n");
    System.out.printf("入力ファイル名1: %s\n", file1);
    System.out.printf("入力ファイル名2: %s\n", file2);
    System.out.printf("入力ファイル名3: %s\n", file3);
    System.out.print("******************************\n");
  }

  // MxKの行列AとKxNの行列Bの乗算結果を返す
  public Matrix multiply(Matrix B) {
    // Kが一致しない場合終了
    if (this.col != B.row) {
      System.err.println("Kが一致していません");
      System.exit(1);
    }
    // 3 <= M, N, K <= 10でない場合終了
    if (this.row < 3 || this.row > 10 || this.col < 3 || this.row > 10 || B.col < 3 || B.col > 10) {
      System.err.println("行と列のサイズは3以上10以下にしてください");
      System.exit(1);
    }
    // M, N, Kがすべて等しい場合終了
    if (this.row == this.col && this.col == B.col) {
      System.err.println("M, N, Kのうちどれかひとつは他と異なる値にしてください");
      System.exit(1);
    }

    // 乗算をおこなう
    Matrix x = new Matrix(this.row, B.col); // MxN行列
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < B.col; j++) {
        for (int k = 0; k < this.col; k++) {
          x.m[i][j] += this.m[i][k] * B.m[k][j];
        }
      }
    }

    return x;
  }

  // 二つのMxN行列の加算結果を返す
  public Matrix add(Matrix B) {
    // 行や列のサイズが異なるときは終了
    if (this.row != B.row || this.col != B.col) {
      System.err.println("行または列のサイズが異なっています");
      System.exit(1);
    }

    // 加算をおこなう
    Matrix x = new Matrix(this.row, this.col); // MxN行列
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        x.m[i][j] = this.m[i][j] + B.m[i][j];
      }
    }

    return x;
  }

  // 二つのMxN行列の減算結果を返す
  public Matrix sub(Matrix B) {
    // 行や列のサイズが異なるときは終了
    if (this.row != B.row || this.col != B.col) {
      System.err.println("行または列のサイズが異なっています");
      System.exit(1);
    }

    Matrix x = new Matrix(this.row, this.col); // MxN行列
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        x.m[i][j] = this.m[i][j] - B.m[i][j];
      }
    }

    return x;
  }

  // 行列の内容を出力
  public void print() {
    for (int i = 0; i < this.row; i++) {
      System.out.print("| ");
      for (int j = 0; j < this.col; j++) System.out.printf("%f ", this.m[i][j]);
      System.out.print(" |\n");
    }
  }

  // M行N列のスペース区切りの実数データを記述したファイルを読み込み，Matrixクラスのオブジェクトを生成
  public Matrix read(String filename) {
    Matrix x = null;

    try {
      br = new BufferedReader(new FileReader(filename));

      // 先頭行の行サイズと列サイズを読み取る
      String line = br.readLine();
      String[] nums = line.split("\\s+");
      this.row = Integer.parseInt(nums[0]);
      this.col = Integer.parseInt(nums[1]);

      // 行列データを読み取る
      x = new Matrix(this.row, this.col);
      for (int i = 0; i < this.row; i++) {
        line = br.readLine();
        nums = line.split("\\s+");
        for (int j = 0; j < this.col; j++) {
          x.m[i][j] = Double.parseDouble(nums[j]);
        }
      }

      if (br != null) br.close();
    }
    catch (FileNotFoundException e) {
      System.err.println("File Open Error: Filename = " + filename);
      System.exit(1);
    }
    catch (NumberFormatException e) {
      System.err.println("Number Format Error: Filename = " + filename);
      System.exit(1);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return x;
  }

  public static void main(String[] args) {
    if (args.length != 3) {
      System.err.println("行列データファイルは三つ与えてください");
      System.exit(1);
    }

    Matrix x = new Matrix();

    x.printMyInfo(args[0], args[1], args[2]);

    // 三つの行列データファイルをそれぞれ読み込む
    Matrix A = x.read(args[0]);
    Matrix B = x.read(args[1]);
    Matrix C = x.read(args[2]);

    // 各行列データをそのまま出力
    System.out.printf("入力行列A サイズ: (%d, %d)\n", A.row, A.col);
    A.print();
    System.out.printf("入力行列B サイズ: (%d, %d)\n", B.row, B.col);
    B.print();
    System.out.printf("入力行列C サイズ: (%d, %d)\n", C.row, C.col);
    C.print();

    // 演算を行う
    Matrix D = A.multiply(B); // D = AxB
    Matrix E = C.add(D);      // E = C+D
    Matrix F = C.sub(D);      // F = C-D

    // 演算結果を出力
    System.out.printf("出力 積行列 D=AxB サイズ: (%d, %d)\n", C.row, C.col);
    D.print();
    System.out.printf("出力 要素和行列 E=C+(AxB) サイズ: (%d, %d)\n", C.row, C.col);
    E.print();
    System.out.printf("出力 要素差行列 F=C-(AxB) サイズ: (%d, %d)\n", C.row, C.col);
    F.print();
  }
}
