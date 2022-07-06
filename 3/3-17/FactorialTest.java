// プログラム3-17 階乗計算プログラム

import java.math.BigInteger;

public class FactorialTest {
  public int Factorial(int n) {
    if (n == 0) return 1;
    return n * Factorial(n - 1);
  }

  public long Factorial(long n) {
    if (n == 0) return 1L;
    return n * Factorial(n - 1);
  }

  public BigInteger Factorial(BigInteger n) {
    if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
      BigInteger t = n.subtract(BigInteger.ONE); // n-1の引算はBigIntegerクラスの引算関数
      BigInteger s = Factorial(t);
      return n.multiply(s);                      // 乗算multiplyもBigIntegerクラスの関数
  }

  public static void main(String[] args) {
    FactorialTest ft = new FactorialTest();

    System.out.println("int Factorial(20) = "  + ft.Factorial(20));  //オーバーフロー
    System.out.println("long Factorial(20) = " + ft.Factorial(20L)); // ぎりぎりOK
    System.out.println("long Factorial(21) = " + ft.Factorial(21L)); // オーバーフロー

    BigInteger big = BigInteger.valueOf(20L);
    System.out.println("BigInteger Factorial(20) = "  + ft.Factorial(big).toString());
    BigInteger big1 = BigInteger.valueOf(21L);  // オーバーフローしない
    System.out.println("BigInteger Factorial(21) = "  + ft.Factorial(big1).toString());
    BigInteger big2 = BigInteger.valueOf(100L);
    System.out.println("BigInteger Factorial(100) = " + ft.Factorial(big2).toString());
  }
}
