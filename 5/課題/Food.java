// 食べ物クラス(各食品の名前，炭水化物，カロリー，タンパク質を管理する)
public class Food {
  private String name;    // 食品名
  private double carbon;  // 炭水化物
  private double calorie; // カロリー
  private double protein; // タンパク質

  public Food() {}

  public Food(String name, double carbon, double calorie, double protein) {
    this.name    = name;
    this.carbon  = carbon;
    this.calorie = calorie;
    this.protein = protein;
  }

  public String getName() { return name; }

  public double getCarbon() { return carbon; }

  public double getCalorie() { return calorie; }

  public double getProtein() { return protein; }
}
