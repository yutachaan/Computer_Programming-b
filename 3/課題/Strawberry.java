/*
  いちごクラス(果実クラスの派生クラス)

  @作成者: 佐藤 優太
  @提出日: 2022/07/06

  % javacu Strawberry.java
*/

public class Strawberry extends Fruit {
  final static double vitaminC = 0.62;
  final static int price = 500;

  public Strawberry(int howMany) {
    super(Strawberry.vitaminC, Strawberry.price, howMany);
  }

  public void print() {
    System.out.print("<いちご> ");
    super.print();
  }
}
