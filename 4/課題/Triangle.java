import java.lang.Math;
import java.io.PrintStream;

// 三角形クラス
public class Triangle extends Shape2D {
  private Coord2 v1, v2, v3;

  public Triangle(Coord2 v1, Coord2 v2, Coord2 v3, Color c) {
    this.v1 = v1;
    this.v2 = v2;
    this.v3 = v3;
    this.setColor(c);
  }

  public Coord2[] getV() {
    Coord2[] v = {v1, v2, v3};
    return v;
  }

  // 面積を求めて返す
  public double area() {
    double x1 = v1.getX();
    double y1 = v1.getY();
    double x2 = v2.getX();
    double y2 = v2.getY();
    double x3 = v3.getX();
    double y3 = v3.getY();

    return Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) / 2;
  }

  // 周囲長を求めて返す
  public double perimeter() {
    return Coord2.distance(v1, v2) + Coord2.distance(v2, v3) + Coord2.distance(v3, v1);
  }

  // psファイルに出力
  public void psPrint(PrintStream cout) {
    Color c = this.getColor();

    cout.printf("%% 三角形: 面積 = %.3f\n", area());
    cout.printf("%% 三角形: 周囲長 = %.3f\n", perimeter());
    cout.printf("%.3f %.3f %.3f setrgbcolor\n", c.getR(), c.getG(), c.getB());
    cout.print("newpath\n");
    cout.printf("%.3f %.3f moveto\n", v1.getX(), v1.getY());
    cout.printf("%.3f %.3f lineto\n", v2.getX(), v2.getY());
    cout.printf("%.3f %.3f lineto\n", v3.getX(), v3.getY());
    cout.print("closepath\n");
    cout.print("stroke\n\n");
  }
}
