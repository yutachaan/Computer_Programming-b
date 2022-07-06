/*
  みかんクラス(果実クラスの派生クラス)

  @作成者: 佐藤 優太
  @提出日: 2022/07/06

  % javacu Orange.java
*/

public class Orange extends Fruit {
  final static double vitaminC = 0.6;
  final static int    price    = 400;

  public Orange(int howMany) {
    super(Orange.vitaminC, Orange.price, howMany);
  }

  public void print() {
    System.out.print("<みかん> ");
    super.print();
  }
}
