// プログラム3-6: ほうれん草クラス（派生クラス）

public class Spinach extends Vegetable {
	final static double vitaminC = 19.0;
	final static int price = 900;

	public Spinach() {
		super(Spinach.vitaminC, Spinach.price);
	}

	public void print() {
		System.out.print("<ほうれん草>");
		super.print();
	}

	public static void main(String[] args) {
		Spinach spinach = new Spinach();
		spinach.print();
	}
}
