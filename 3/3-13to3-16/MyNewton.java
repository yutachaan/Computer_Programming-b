// プログラム3-15: ニュートン法を実行。事前に作成した関数とその導関数を呼び出す

import java.util.Scanner;

public class MyNewton {
	final static double EPSILON = 1e-10; // 閾値
	final static int ITERATION  = 10;    // 最大反復回数

	// Newton法で非線形関数のゼロ点を求める
	public static void main(String[] args) {
		MyFunction mf = new MyFunctionImpl();

		System.out.println("F(x) = cos(x) - x * x = 0のゼロ点をNewton法で計算します。");
		System.out.print("\n初期値を入力してください。> ");

		double x0;
		Scanner input = new Scanner(System.in);

		try {
		  x0 = input.nextDouble();
		  System.out.printf("\n初期値は，%fです。\n\n", x0);

		  double p1 = x0, p2;
		  for (int i = 0; i < MyNewton.ITERATION; i++) {
			  if (Math.abs(mf.derivative(p1)) < MyNewton.EPSILON) {
				  System.out.println(">>> ゼロ割り算をしようとしています。");
				  return;
			  }

			  p2 = p1 - mf.function(p1) / mf.derivative(p1);
			  if (Math.abs(p2 - p1) < MyNewton.EPSILON) {
				  System.out.println(">>> 収束しました。");
				  return;
			  }

			  System.out.printf(">> 現在の解は%fです。\n", p2);
			  p1 = p2;
		  }

		  System.out.println(">>> 収束しませんでした。");
		}
		catch (Exception e) {
		  System.err.println("予期せぬ入力値がありました");
		  System.exit(1);
		}
	}
}
