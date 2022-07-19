import java.util.ArrayList;

// Foodクラス用の回帰クラス
public class FoodRegression extends Regression {
  public FoodRegression(ArrayList<Double> variables, ArrayList<Double> values) { super(variables, values); }

  // xmeanとymeanを計算
  public void compMean() {
    // xmeanを計算
    for (int i = 0; i < this.samples; i++) this.xmean += this.variables.get(i);
    this.xmean /= this.samples;

    // ymeanを計算
    for (int i = 0; i < this.samples; i++) this.ymean += this.values.get(i);
    this.ymean /= this.samples;
  }

  // 単回帰をおこない，predicted, a, b, R2を計算
  public void doRegression() {
    this.compMean();

    double sxx = 0, syy = 0, sxy = 0, pymean = 0, spypy = 0, sypy = 0;

    // sxx, syy, sxyを計算
    for (int i = 0; i < this.samples; i++) {
      sxx += Math.pow(this.variables.get(i) - this.xmean, 2);
      syy += Math.pow(this.values.get(i) - this.ymean, 2);
      sxy += (this.variables.get(i) - this.xmean) * (this.values.get(i) - this.ymean);
    }

    // a, bを計算
    this.a = sxy / sxx;
    this.b = this.ymean - this.a * this.xmean;

    // predictedを計算
    for (int i = 0; i < this.samples; i++) this.predicted.set(i, this.a * this.variables.get(i) + this.b);

    // R2の計算式の各部分を計算
    for (int i = 0; i < this.samples; i++) pymean += this.predicted.get(i);
    pymean /= this.samples;

    for (int i = 0; i < this.samples; i++) {
      spypy += Math.pow(this.predicted.get(i) - pymean, 2);
      sypy += (this.values.get(i) - ymean) * (this.predicted.get(i) - pymean);
    }

    // R2を計算
    this.R2 = Math.pow(sypy, 2) / (syy * spypy);
  }
}
