// プログラム1-4: 実数精度のチェック

public class RealPrecisionTest {
  public static void main(String[] args) {
    float  realFloat  = 1.0F;
    double realDouble = 1.0;

    for (int i = 0; i < 25; i++) {
      realFloat  *= 0.03F;
      realDouble *= 0.03;
    }

    String form1 = String.format("realFloat      = %24.23e\n", realFloat);
    System.out.println(form1);
    System.out.println("                       | ここまで有効\n");
    String form2 = String.format("realDouble     = %24.23e\n", realDouble);
    System.out.println(form2);
    System.out.println("                                | ここまで有効\n");
  }
}
