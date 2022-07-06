/*
  果実クラス(基底クラス)

  @作成者: 佐藤 優太
  @提出日: 2022/07/06

  % javacu Fruit.java
*/

public class Fruit {
  private double vitaminC; // ビタミンC含有量(1kgあたりの量(g))
  private int price;       // 価格
  private int howMany;     // 購入量(kg)

  public Fruit(double vitaminC, int price, int howMany) {
    this.vitaminC = vitaminC;
    this.price    = price;
    this.howMany  = howMany;
  }

  public double getVitaminC() {
    return vitaminC;
  }

  public int getPrice() {
    return price;
  }

  public int getHowMany() {
    return howMany;
  }

  // 購入量を出力
  public void print() {
    System.out.println(howMany + "kg");
  }
}
