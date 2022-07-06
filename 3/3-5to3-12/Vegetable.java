// プログラム3-5: 野菜クラス（基底クラス）

public class Vegetable {
	protected double vitaminC; // ビタミンＣ含有量：100gあたり
	protected int price;       // 野菜の小売価格: 1kgあたり

	public Vegetable(double vitaminC, int price) {
		this.vitaminC = vitaminC;
		this.price = price;
	}

	public void print() {
		System.out.println("  ビタミンC: " + vitaminC + "mg/100g  小売価格" + price + "円/kg");
	}

	public double getVitaminC() {
    return vitaminC;
  }

	public int getPrice() {
    return price;
  }
}
