import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Matrix {
  private BufferedReader br = null;
  private double[][] m = null; // MxNの行列
  private int row, col;      // 行サイズと列サイズ

  public Matrix() {
    m = new double[0][0];
  }

  public Matrix(int M, int N) {
    m = new double[M][N];
    this.row = M; this.col = N;
  }

  // 自分の名前や学籍番号などの情報を出力する(file1, file2: 入力ファイル名)
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

  // // MxKの行列AとKxNの行列Bの乗算結果を返す
  // public Matrix multiply(Matrix B) {
  //   // 3 <= M, N, K <= 10でない場合警告を出して終了
  //   // M, N, Kのうちどれかひとつは他と異なる値とする．そうでない場合は警告を出して終了
  //   // Kが一致しない場合警告を出して終了
  // }

  // // 2つの行列の加算
  // public Matrix add(Matrix B) {
  //   // 行や列のサイズが異なるときは警告を出してプログラムを終了
  // }

  // // 2つの行列の減算
  // public Matrix sub(Matrix B) {
  //   // 行や列のサイズが異なるときは警告を出してプログラムを終了
  // }

  // 行列の中身を出力
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

      // 先頭行に行のサイズと列のサイズがあるからそれを読み取る
      String line = br.readLine();
      String[] nums = line.split("\\s+");
      this.row = Integer.parseInt(nums[0]); this.col = Integer.parseInt(nums[1]);

      // 次の行からデータが並ぶ
      x = new Matrix(this.row, this.col);
      for (int i = 0; i < this.row; i++) {
        line = br.readLine();
        nums = line.split("\\s+");
        for (int j = 0; j < this.col; j++) x.m[i][j] = Double.parseDouble(nums[j]);
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
      System.err.println("行列データファイルは3つ与えてください");
      System.exit(1);
    }

    Matrix x = new Matrix();

    x.printMyInfo(args[0], args[1], args[2]);

    Matrix A = x.read(args[0]);
    Matrix B = x.read(args[1]);
    Matrix C = x.read(args[2]);

    System.out.printf("入力行列A サイズ: (%d, %d)\n", A.row, A.col);
    A.print();
    System.out.printf("入力行列B サイズ: (%d, %d)\n", B.row, B.col);
    B.print();
    System.out.printf("入力行列C サイズ: (%d, %d)\n", C.row, C.col);
    C.print();

    // Matrix D = A.multiply(B);
    // Matrix E = C.add(D);
    // Matrix F = C.sub(D);

    // D.print();
    // E.print();
    // F.print();
  }
}
