// プログラム3-7: キャベツクラス（派生クラス）

public class Cabbage extends Vegetable {
	final static double vitaminC = 17.0;
	final static int price = 80;

	public Cabbage() {
		super(Cabbage.vitaminC, Cabbage.price);
	}

	public void print() {
		System.out.print("<キャベツ> ");
		super.print();
	}

	public static void main(String[] args) {
		Cabbage cabbage = new Cabbage();
		cabbage.print();
	}
}
