// プログラム2-10: ２次元の点(x,y)を表すクラス:配列バージョン

public class Point2 {
  private double[] v = null; // 2次元の点

  public Point2() {
    v = new double[2];
  }

  // コンストラクタ（オーバーロード）
  public Point2(double x, double y) {
    v = new double[2];
    v[0] = x; v[1] = y;
  }

  // 原点からのユークリッド距離
  public double distanceFromOrigin() {
    return Math.sqrt(v[0] * v[0] + v[1] * v[1]);
  }

  // 自分自身とp1との和を計算
  public Point2 add(Point2 p1){
    Point2 p2 = new Point2();

    p2.v[0] = this.v[0] + p1.v[0];
    p2.v[1] = this.v[1] + p1.v[1];

    return p2;
  }

  // 点を返す
  public double[] getPoint2() {
    return v;
  }

  // Point2クラスのメンバー変数をプリントする関数
  public void print(String something) {
    if (something != null && something != "") System.out.println(something);
    System.out.printf("Point2の座標 = (%f, %f)\n", v[0], v[1]);
  }

  public static void main(String[] args) {
    Point2 a = new Point2(3.0, -1.0);
    a.print("----a----");

    Point2 b = new Point2(-2.0, 5.0);
    b.print("----b----");

    Point2 c = a.add(b);
    c.print("----c----");
  }
}
