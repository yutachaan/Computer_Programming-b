import java.lang.Math;
import java.io.PrintStream;

// 円クラス
public class Circle extends Shape2D {
  private Coord2 v; // 円の中心座標
  private double r; // 円の半径

  public Circle(Coord2 v, double r, Color c) {
    this.v = v;
    this.r = r;
    this.setColor(c);
  }

  public Coord2 getV() { return v; }

  public double getR() { return r; }

  // 面積を求めて返す
  public double area() { return Math.PI * r * r; }

  // 周囲長を求めて返す
  public double perimeter() { return 2 * Math.PI * r; }

  // psファイルに出力
  public void psPrint(PrintStream cout) {
    Color c = this.getColor();

    cout.printf("%% 円: 面積 = %.3f\n", area());
    cout.printf("%% 円: 周囲長 = %.3f\n", perimeter());
    cout.printf("%.3f %.3f %.3f setrgbcolor\n", c.getR(), c.getG(), c.getB());
    cout.print("newpath\n");
    cout.printf("%.3f %.3f %.3f 0 360 arc\n", v.getX(), v.getY(), r);
    cout.print("stroke\n\n");
  }
}
