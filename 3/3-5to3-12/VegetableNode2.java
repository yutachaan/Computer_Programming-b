// プログラム3-11: 線形リストではなく、Vegetableクラスと個数だけ保持させるクラス

public class VegetableNode2 {
	private Vegetable vegetable;
	private int howMany; // 何個（何kg）買ったか

	public VegetableNode2(Vegetable vegetable, int howMany) {
		this.vegetable = vegetable;
		this.howMany   = howMany;
	}

	public Vegetable getVegetable() {
    return vegetable;
  }

	public int getHowMany() {
    return howMany;
  }

	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}

	public void add() {
		this.howMany++;
	}

	public void print(String cont, int howMany) {
		if (cont.equals("")) {
			System.out.printf(" (%d個）", howMany);
			vegetable.print();
		}
		else {
			System.out.printf(" (%d個）", howMany);
			vegetable.print();
			System.out.print(" ->");
		}
	}
}
