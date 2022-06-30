// プログラム2-9-2: Pointクラスを呼び出すクラス

public class CallPoint {
  private double x, y;

  public CallPoint(double x, double y) {
    Point p = new Point(x, y);

    System.out.println("x = " + p.x + "  y = " + p.y); // エラー
  }
}
