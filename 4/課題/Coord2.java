import java.lang.Math;

// 2次元座標を表現するクラス
public class Coord2 {
  private double x, y; // 座標

  public Coord2(double x, double y) { this.x = x; this.y = y; }

  public double getX() { return x; }

  public double getY() { return y; }

  public void setCoord2(double x, double y) { this.x = x; this.y = y; }

  // 2点間のユークリッド距離を求めて返す
  public static double distance(Coord2 v1, Coord2 v2) {
    double x1 = v1.x, y1 = v1.y, x2 = v2.x, y2 = v2.y;

    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }
}
