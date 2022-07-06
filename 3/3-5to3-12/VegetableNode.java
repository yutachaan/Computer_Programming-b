// プログラム3-8: 線形リストのノードクラス

public class VegetableNode {
	private Vegetable vegetable;
	private int howMany; // 何個（何kg）買ったか
	private VegetableNode next;

	public VegetableNode(Vegetable vegetable, int howMany, VegetableNode next) {
		this.vegetable = vegetable;
		this.howMany = howMany;
		this.next = next;
	}

	public Vegetable getVegetable() {
    return vegetable;
  }

	public int getHowMany() {
    return howMany;
  }

	public VegetableNode getNext() {
    return next;
  }

	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}

	public void setNext(VegetableNode next) {
    this.next = next;
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
