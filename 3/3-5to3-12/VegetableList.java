// プログラム3-9: 線形リストの生成と動的修正

public class VegetableList {
	private VegetableNode head;

	public VegetableList() {
		head = null;
	}

	public void insert(Vegetable vegetable, int howMany) {
		if (head == null) head = new VegetableNode(vegetable, howMany, null);
    else {
      VegetableNode p = new VegetableNode(vegetable, howMany, head);
      head = p;
    }

		return;
	}

	public void print() {
		double vitaminC = 0.0;
		int price = 0;
		VegetableNode p = head;

		while (p != null) {
			Vegetable v = p.getVegetable();

			int h     = p.getHowMany();
			vitaminC += h * v.getVitaminC();
			price    += h * v.getPrice();

			if (p.getNext() != null) p.print("something", h);
			else p.print("", h);

			p = p.getNext();
		}

		System.out.println("------------------------");
		System.out.printf("ビタミンC総量: %f(mg)\n", vitaminC);
		System.out.printf("価格総額: %d 円\n", price / 10);
		System.out.println("------------------------");
	}
}
