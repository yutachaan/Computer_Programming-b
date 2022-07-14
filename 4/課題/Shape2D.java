import java.io.PrintStream;

// 2次元図形クラス(基底クラス)
public abstract class Shape2D {
  abstract double area();                  // 図形の面積を求めて返す
  abstract double perimeter();             // 図形の周囲長を求めて返す
  abstract void psPrint(PrintStream cout); // 図形の情報をpsファイルに出力する

  private Color color;

  public void setColor(Color c) { this.color = c; }

  public Color getColor() { return color; }
}
