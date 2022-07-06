// プログラム3-14: インタフェースで関数の具体例を与えるクラス

public class MyFunctionImpl implements MyFunction {
  public double function(double x) {
    return Math.cos(x) - x * x;
  }

  public double derivative(double x) {
    return -(Math.sin(x) + 2 * x);
  }

  public void print() {
    System.out.println("関数　f(x) = cos(x) - x * x");
  }
}
