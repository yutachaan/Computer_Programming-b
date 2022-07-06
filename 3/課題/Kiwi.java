/*
  キウイクラス(果実クラスの派生クラス)

  @作成者: 佐藤 優太
  @提出日: 2022/07/06

  % javacu Kiwi.java
*/

public class Kiwi extends Fruit {
  final static double vitaminC = 1.4;
  final static int    price    = 600;

  public Kiwi(int howMany) {
    super(Kiwi.vitaminC, Kiwi.price, howMany);
  }

  public void print() {
    System.out.print("<キウイ> ");
    super.print();
  }
}
