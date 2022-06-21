// プログラム1-1： 1からNまでの二乗和を求めてプリントする

public class SquaredSum {
  public double sumSquare(int N) {
    double result = 0.0;

    for (int i = 1; i <= N; i++) result += i * i;

    return result;
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("java(u) SquaredSum [正の整数値]");
      System.exit(1);
    }
    try {
      int N = Integer.valueOf(args[0]).intValue();
      if (N < 0) {
        System.out.println("正の整数値を入力してください");
        System.exit(1);
      }

      SquaredSum s = new SquaredSum();

      double r = s.sumSquare(N);

      System.out.println("1から" + N + "までの2乗和の計算\n\t1 * 1 + ... + N * N = " + r);
    }
    catch (NumberFormatException e){
      System.out.println("整数値以外が入力されました");
      System.exit(2);
    }
  }
}
