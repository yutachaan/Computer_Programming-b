// プログラム3-13: インタフェースで実装するクラスに要求する関数の枠組みを指示

public interface MyFunction {
	double function(double x);   // 何かの関数本体部分: f(x)
	double derivative(double x); // その関数の微分値を返す関数: f'(x)
	void print();
}
