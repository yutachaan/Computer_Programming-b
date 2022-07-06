// プログラム3-10: VegetableMainクラス

import java.util.Scanner;

public class VegetableMain {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int number1; // 買いたい野菜
    int number2; // 買いたい個数

    VegetableList vl = new VegetableList();
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

       vl.insert(vegetable, number2);
      }
    }
    catch (Exception e) {
      System.err.println("予備せぬ入力値がありました");
      System.exit(1);
    }

    vl.print();
  }
}
