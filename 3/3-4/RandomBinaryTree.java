// プログラム3-4: ランダムにノードの値を生成する２分探索木クラス

import java.util.Date;
import java.util.Random;

public class RandomBinaryTree {
	Random rand;
	int min = Integer.MIN_VALUE;
	int max =Integer.MAX_VALUE;
	int[] count;    // 乱数発生回数
	int[] sequence; // 乱数そのもの

	public int[] getCount() {
		return count;
	}

	public int[] getRandSequence() {
		return sequence;
	}

	public int getRand() {
		int x = min + rand.nextInt(max - min + 1);
		return x;
	}

	public void init() {
		Date date = new Date();
		rand = new Random(date.getTime());
	}

	public void init(int min, int max) {
		init();
		this.min = min;
		this.max = max;
		count = new int[max - min + 1];
	}

	public void generate(int num) {
		sequence = new int[num];
		for (int i = 0; i < num; i++) {
			int k = getRand();
			sequence[i] = k;
			count[k - min]++;
		}
	}

	public static void main(String[] args) {
		RandomBinaryTree rb = new RandomBinaryTree();
		int num = Integer.valueOf(args[0]).intValue(); // 発生する乱数の総数
		int min = 0, max = 1;

		try {
		  if (args.length > 2) {
			  min = Integer.valueOf(args[1]).intValue();
			  max = Integer.valueOf(args[2]).intValue();
			  rb.init(min, max);
		  }
		  else rb.init();
		}
		catch (Exception e) {
		  System.out.println("整数値を入力してください");
		  System.exit(1);
		}

		rb.generate(num);
		int[] cnt = rb.count = rb.getCount();
		rb.sequence = rb.getRandSequence();

		for (int i = 0; i < rb.sequence.length; i++) System.out.println("乱数発生順序[" + (i) + "] = " + rb.sequence[i]);
		for (int i = min; i < max + 1; i++) System.out.printf("count[%d] = %d\n", i, cnt[i - min]);

		BinaryTree root = new BinaryTree(rb.sequence[0]);
		for (int i = 1; i < rb.sequence.length; i++) root.insert(rb.sequence[i]);

		System.out.println("２分探索木のルート：");
		root.print(root);
		System.out.println("ルートから中順序で再帰的に出力：");
		root.inOrder(root);
	}
}
