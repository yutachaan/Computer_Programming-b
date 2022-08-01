/*
  ボールクラス

  @作成者: 佐藤 優太
  @提出日: 2022/07/30
*/

import java.util.Random;
import java.util.Date;

public class Ball {
  private float radius;       // ボールの半径
  private float r, g, b;      // 色
  private double x, y;         // 位置
  private double dx, dy;       // 方向ベクトル
  private double lastx, lasty; // 直前の位置

  Date date   = new Date();
  Random rand = new Random(date.getTime());

  public Ball() {
    this.radius = rand.nextFloat(80) + 1;
    this.r = rand.nextFloat(1);
    this.g = rand.nextFloat(1);
    this.b = rand.nextFloat(1);
    this.x = this.lastx = rand.nextDouble(400);
    this.y = this.lasty = rand.nextDouble(400);
    this.dx = rand.nextDouble(80) - 40;
    this.dy = rand.nextDouble(80) - 40;
  }

  public float getRadius() { return radius; }

  public float getR() { return r; }

  public float getG() { return g; }

  public float getB() { return b; }

  public double getX() { return x; }

  public double getY() { return y; }

  public double getDx() { return dx; }

  public double getDy() { return dy; }

  public double getLastx() { return lastx; }

  public double getLasty() { return lasty; }

  public void setX(double x) { this.x = x; }

  public void setY(double y) { this.y = y; }

  public void setDx(double dx) { this.dx = dx; }

  public void setDy(double dy) { this.dy = dy; }

  public void setLastx(double lastx) { this.lastx = lastx; }

  public void setLasty(double lasty) { this.lasty = lasty; }
}
