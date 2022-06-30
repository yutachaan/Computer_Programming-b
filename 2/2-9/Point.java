// プログラム2-9: ２次元の点(x,y)を表すクラス

public class Point {
  private double x, y;

  // コンストラクタ
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // 原点からのユークリッド距離
  public double distanceFromOrigin() {
    return Math.sqrt(x * x + y * y);
  }

	public static void main(String[] args) {
		Point p = new Point(3.0, 4.0);

		System.out.println("x = " + p.x + "  y = " + p.y);
		System.out.printf("distance from origin = %f", p.distanceFromOrigin());
	}
}
