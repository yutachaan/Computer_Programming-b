// ２次元の点(x,y)をランダムに複数発生

import java.util.Date;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class DrawRandomPoint2 extends JPanel { // JPanelを継承
  Random rand;
  int numPoints;
  Point2[] pArray;
  double min = 0.0, max = 400.0;
  final static int POINT_RADIUS = 10;  // paintで使う点を近似する円の半径
  final static int FRAME_SIZE   = 500; // Swingのウィンドウのサイズ

  // [min,max]の間の乱数値を発生
  public double getRand() {
    double x = min + (max - min) * rand.nextDouble();
    return x;
  }

  // 乱数で点を生成
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

  // Swingウィンドウで描画
  public void paintComponent(Graphics g) {
    super.paintComponent(g); // JPanelクラスのpaintComponentメソッドの呼び出し
    g.setColor(Color.RED);

    for (int i = 0; i < numPoints; i++) {
      double[] x = pArray[i].getPoint2();
      g.fillOval((int)x[0], (int)x[1], POINT_RADIUS, POINT_RADIUS); // 点を円で塗りつぶし
    }
  }

  public static void main(String[] args) {
    DrawRandomPoint2 panel = new DrawRandomPoint2();
    JFrame application = new JFrame(); // JFrameクラスでWindowを準備
    try {
      if (args.length < 1) {
        System.out.println("発生したい点の数を入力してください");
        System.exit(1);
      }

      int numPoints = Integer.valueOf(args[0]).intValue();
      if (args.length > 2) {
        double min = Double.valueOf(args[1]).doubleValue();
        double max = Double.valueOf(args[2]).doubleValue();
        panel.init(numPoints, min, max);
      }
      else panel.init(numPoints, panel.min, panel.max);

      panel.generate(); // パネル内の点を発生
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Windowを閉じると終了
      application.add(panel); // JFrameにJPanelを加える

      int size = DrawRandomPoint2.FRAME_SIZE;
      if (args.length > 2) size =(int)(panel.max - panel.min);

      application.setSize(size, size); // JFrameのサイズ
      application.setVisible(true); // Windowを表示
    }
    catch (NumberFormatException e) {
      System.out.println("期待している数値（整数値、あるいは実数値）以外が入力されました");
      System.exit(2);
    }
  }
}
