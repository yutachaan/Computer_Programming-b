import java.io.PrintStream;

// 正方形クラス
public class Square extends Shape2D {
  private Coord2 v; // 正方形の中心座標
  private double w; // 一辺の長さ

  public Square(Coord2 v, double w, Color c) {
    this.v = v;
    this.w = w;
    this.setColor(c);
  }

  public Coord2 getV() { return v; }

  public double getW() { return w; }

  // 面積を求めて返す
  public double area() { return w * w; }

  // 周囲長を求めて返す
  public double perimeter() { return 4 * w; }

  // psファイルに出力
  public void psPrint(PrintStream cout) {
    Color c = this.getColor();
    double ww = w / 2;

    cout.printf("%% 正方形: 面積 = %.3f\n", area());
    cout.printf("%% 正方形: 周囲長 = %.3f\n", perimeter());
    cout.printf("%.3f %.3f %.3f setrgbcolor\n", c.getR(), c.getG(), c.getB());
    cout.print("newpath\n");
    cout.printf("%.3f %.3f moveto\n", v.getX() - ww, v.getY() - ww);
    cout.printf("%.3f %.3f lineto\n", v.getX() - ww, v.getY() + ww);
    cout.printf("%.3f %.3f lineto\n", v.getX() + ww, v.getY() + ww);
    cout.printf("%.3f %.3f lineto\n", v.getX() + ww, v.getY() - ww);
    cout.print("closepath\n");
    cout.print("stroke\n\n");
  }
}
