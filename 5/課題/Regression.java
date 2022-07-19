import java.util.ArrayList;

// 回帰クラス
public abstract class Regression {
  protected double a, b;         // 係数
  protected double R2;           // 寄与率
  protected double xmean, ymean; // xmean: 説明変数の平均値， ymean: 目的変数の平均値
  protected int samples;         // データのサンプル数
  protected ArrayList<Double> variables = new ArrayList<Double>();  // 説明変数
  protected ArrayList<Double> values    = new ArrayList<Double>();    // 目的変数
  protected ArrayList<Double> predicted = new ArrayList<Double>(); // 目的変数の予測値

  public Regression(ArrayList<Double> variables, ArrayList<Double> values) {
    this.a = 0;
    this.b = 0;
    this.R2 = 0;
    this.xmean = 0;
    this.ymean = 0;
    this.samples = variables.size();

    for (int i = 0; i < samples; i++) this.variables.add(variables.get(i));
    for (int i = 0; i < samples; i++) this.values.add(values.get(i));
    for (int i = 0; i < samples; i++) this.predicted.add(0.0);
  }

  public abstract void compMean();     // xmeanとymeanを計算

  public abstract void doRegression(); // predicted, a, b, R2を計算

  public double getA() { return a; }

  public double getB() { return b; }

  public double computeR2() { return R2; }
}
