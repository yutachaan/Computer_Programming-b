// プログラム3-12: VegetableMainクラス (ArrayList版）

import java.util.Scanner;
import java.util.ArrayList;

public class VegetableMain2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int number1; // 買いたい野菜
    int number2; // 買いたい個数

    ArrayList<VegetableNode2> vl = new ArrayList<VegetableNode2>();
    Vegetable vegetable = null;

    try {
      while (true) {
        System.out.print( "ほうれん草(1), キャベツ(2), 終了(0) " + "のどれかの整数を入力してください  > " );
        number1 = input.nextInt();
        if (number1 == 0) break;
        do {
          System.out.print( "買いたい個数を入力してください  > " );
          number2 = input.nextInt();
          if (number2 <= 0) System.out.println("正の整数を入力してください");
          else break;
        } while (true);

        // 野菜の種類ごとに線形リストに挿入
        switch (number1) {
          case 1: vegetable = new Spinach(); break;
          case 2: vegetable = new Cabbage(); break;
        }

        vl.add(new VegetableNode2(vegetable, number2));
      }
    }
    catch (Exception e) {
      System.err.println("予期せぬ入力値がありました");
      System.exit(1);
    }

    double vitaminC = 0.0;
    int price = 0;
    for (int i = 0; i < vl.size(); i++) {
      VegetableNode2 node = (VegetableNode2)vl.get(i);
      Vegetable v = node.getVegetable();

      int h     = node.getHowMany();
      vitaminC += h * v.getVitaminC();
      price    += h * v.getPrice();
    }

    System.out.println("------------------------");
    System.out.printf("ビタミンC総量： %f(mg)\n", 10 * vitaminC);
    System.out.printf("価格総額： %d 円\n", price);
    System.out.println("------------------------");
  }
}
