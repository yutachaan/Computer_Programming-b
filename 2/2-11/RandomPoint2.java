// プログラム2-11: 2次元の点(x,y)をランダムに複数発生

import java.util.Date;
import java.util.Random;

public class RandomPoint2 {
  Random rand;
  int numPoints;                 // 点の数
  Point2[] pArray;               // Point2クラスのオブジェクト保持配列
  double min = 0.0, max = 400.0; // 最小値minから最大値maxまでの範囲の数をランダムに生成

  // 実数値で[min,max]の間で乱数発生
  public double getRand() {
    double x = min + (max - min) * rand.nextDouble();
    return x;
  }

  // Point2クラスレベルで乱数発生
  public void generate() {
    for (int i = 0; i < numPoints; i++) {
      pArray[i] = new Point2(getRand(), getRand());
      pArray[i].print("");
    }
  }

  public void init(int numPoints) {
    Date date = new Date();
    rand = new Random(date.getTime());
    this.numPoints = numPoints;
    pArray = new Point2[numPoints];
  }

  public void init(int numPoints, double min, double max) {
    init(numPoints);
    this.min = min;
    this.max = max;
  }

  public static void main(String[] args) {
    RandomPoint2 rp2 = new RandomPoint2();
    int numPoints = Integer.valueOf(args[0]).intValue();

    if (args.length >= 3) {
      double min = Double.valueOf(args[1]).doubleValue();
      double max = Double.valueOf(args[2]).doubleValue();

      rp2.init(numPoints, min, max);
    }
    else rp2.init(numPoints);

    rp2.generate();
  }
}
