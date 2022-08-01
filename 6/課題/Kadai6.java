/*
  ボールのアニメーション

  @作成者: 佐藤 優太
  @提出日: 2022/07/30

  % javacu Kadai6.java
  % javau Kadai6 [number of balls]
*/

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Kadai6 extends JFrame implements Runnable, KeyListener {
  int sleepTime = 10; // 休止時間（ミリ秒）

  // ボールデータ
  int numBalls; // ボールの数
  Ball[] balls = null;
  Ball[] saveBalls = null;

  // オフスクリーン画像用のデータ
  Thread thread = null;
  Thread saveThread = null;
  Image offScreenImage = null;
  Image backGroundImage = null;
  Graphics backG = null;
  Graphics offG = null;
  Graphics saveOffG = null;
  Graphics2D offG2 = null;
  private int w; // 横幅
  private int h; // 縦幅
  java.awt.Color backColor = new java.awt.Color(1.0f, 1.0f, 1.0f);

  public Kadai6(String name) { super(name); }

  public void init(int numBalls) {
    Dimension d = getSize();
    w = d.width;
    h = d.height;

    // オフスクリーン画像用のデータ領域
    offScreenImage = createImage(w, h);
    offG = saveOffG = offScreenImage.getGraphics();
    offG2 = (Graphics2D)offG;
    backGroundImage = createImage(w, h);
    backG = backGroundImage.getGraphics();
    backG.setColor(backColor);
    backG.fillRect(0, 0, w, h);

    addKeyListener(this); //キーボードのリスナーを設定

    // Ballを生成
    this.numBalls = numBalls;
    balls = new Ball[numBalls];
    saveBalls = new Ball[numBalls];
    for (int i = 0; i < numBalls; i++) {
      balls[i] = new Ball();
      saveBalls[i] = balls[i];
    }
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) quit();
    else if (e.getKeyCode() == KeyEvent.VK_S) stop();
    else if (e.getKeyCode() == KeyEvent.VK_R) resume();
  }

  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}

  public void quit() { System.exit(0); }

  public void stop() {
    if (thread != null) {
      for (int i = 0; i < numBalls; i++) saveBalls[i] = balls[i];
      offG = null; // thread.stop()は非推奨なのでpaintを空回りさせ動きをストップさせる
      thread = null;
    }
  }

  public void resume() {
	  if (offG == null && thread == null) {
      offG = saveOffG;
      thread = saveThread;
      for (int i = 0; i < numBalls; i++) balls[i] = saveBalls[i];
    }
  }

  public void start() {
    if (thread == null) {
      thread = saveThread = new Thread(this);
      thread.start();
    }
  }

  public void run() {
    while (true) {
      animate();
      try {
        Thread.sleep(sleepTime);
      }
      catch (InterruptedException e) {}
    }
  }

  public void paint(Graphics g) {
      // キャンバスが準備できていない場合は何もしない
      if (offG == null || backGroundImage == null) return;

      // 背景オフスクリーン画像を描画
      offG.drawImage(backGroundImage, 0, 0, this);

      float[] dist = {0.15f, 0.8f};
      for (int i = 0; i < numBalls; i++) {
        java.awt.Color centerColor = new java.awt.Color(balls[i].getR(), balls[i].getG(), balls[i].getB());
        java.awt.Color color2 = new java.awt.Color(Math.max((int)(1.25 * balls[i].getR()), 255), Math.max((int)(1.25 * balls[i].getG()), 255), Math.max((int)(1.25 * balls[i].getB()), 255));
        Point2D center = new Point2D.Double(balls[i].getX(), balls[i].getY());
        Color[] colors = {color2, centerColor};
        RadialGradientPaint rgp = new RadialGradientPaint(center, balls[i].getRadius(), dist, colors);
        offG2.setPaint(rgp);/* ボールの色塗り設定 (Graphics2Dクラス(offG2)が必要）*/
        offG.fillOval((int)(balls[i].getX() - balls[i].getRadius()), (int)(balls[i].getY() - balls[i].getRadius()), (int)(balls[i].getRadius() * 2), (int)(balls[i].getRadius() * 2));
        g.drawImage(offScreenImage, 0, 0, this);
      }
  }

  public void animate() {
    if (thread != null) {
      for (int i = 0; i < numBalls; i++) {
        java.awt.Rectangle bounds = getBounds();
        if ((balls[i].getX() - balls[i].getRadius() + balls[i].getDx() < 0) || (balls[i].getX() + balls[i].getRadius() + balls[i].getDx() > bounds.width)) balls[i].setDx(-balls[i].getDx());
        if ((balls[i].getY() - balls[i].getRadius() + balls[i].getDy() < 0) || (balls[i].getY() + balls[i].getRadius() + balls[i].getDy() > bounds.height)) balls[i].setDy(balls[i].getDy());

        // 円の移動
        balls[i].setX(balls[i].getLastx() + balls[i].getDx());
        balls[i].setY(balls[i].getLasty() + balls[i].getDy());

        balls[i].setLastx(balls[i].getX());
        balls[i].setLasty(balls[i].getY());

        repaint();
      }
    }
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("java Kadai6 [number of balls]");
      System.exit(1);
    }
    try {
      int n = Integer.valueOf(args[0]).intValue();

      if (n < 10 && n > 30) {
        System.err.println("10〜30の数を指定してください");
        System.exit(1);
      }

      String info = "佐藤優太 2020/7/30 ボール数: " + n;

      Kadai6 kadai = new Kadai6(info);
      kadai.setSize(600, 600);
      kadai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      kadai.setVisible(true);

      kadai.init(n);
      kadai.start();
    }
    catch (NumberFormatException e) {
      System.err.println("引数に10〜30の間の整数を与えてください");
      System.exit(1);
    }
  }
}
