/*
  生成した果実のインスタンスを管理し，結果を出力する

  @作成者: 佐藤 優太
  @提出日: 2022/07/06

  % javacu Kadai3.java
  % javau Kadai3 [買うキウイの重さ(kg)] [買うみかんの重さ(kg)] [買ういちごの重さ(kg)]
*/

public class Kadai3 {
  // 自分の名前や学籍番号などの情報を出力する
  public void printMyInfo(int param1, int param2, int param3) {
    System.out.print("******************************\n");
    System.out.print("名前: 佐藤 優太\n");
    System.out.print("学籍番号: B223330\n");
    System.out.print("提出日: 2022/07/06\n");
    System.out.printf("入力パラメータ: %d %d %d\n", param1, param2, param3);
    System.out.print("******************************\n");
  }

  public static void main(String[] args) {
    Kadai3 kadai = new Kadai3();

    Fruit[] fruit = new Fruit[3]; // 各果実のインスタンスを保持(0: キウイ， 1: みかん， 2: いちご)

    try {
      fruit[0] = new Kiwi(Integer.parseInt(args[0]));
      fruit[1] = new Orange(Integer.parseInt(args[1]));
      fruit[2] = new Strawberry(Integer.parseInt(args[2]));

      kadai.printMyInfo(fruit[0].getHowMany(), fruit[1].getHowMany(), fruit[2].getHowMany());

      // ビタミンCの総含有量(g)と果実の総額を計算し，結果を出力
      double vitaminC = 0;
      int price = 0;
      for (int i = 0; i < 3; i++) {
        int n = fruit[i].getHowMany(); // 買った量
        vitaminC += n * fruit[i].getVitaminC();
        price    += n * fruit[i].getPrice();

        fruit[i].print(); // 購入量(kg)を出力
      }

      System.out.println("ビタミンC総量 = " + vitaminC + "(g)");
      System.out.println("値段 = " + price + "円");
    }
    catch (NumberFormatException e) {
      System.out.println("整数値以外が入力されました");
      System.exit(1);
    }
  }
}
