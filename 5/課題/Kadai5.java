/*
  食品の炭水化物/タンパク質からカロリーを回帰分析する

  @作成者: 佐藤 優太
  @提出日: 2022/07/19

  % javacu Kadai5.java
  % javau Kadai5 food.csv [C/P (C: Carbon, P: protein)]
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Kadai5 {
  private BufferedReader br = null;

  // 自分の名前や学籍番号などの情報を出力する
  public void printMyInfo() {
    System.out.print("******************************\n");
    System.out.print("名前: 佐藤 優太\n");
    System.out.print("学籍番号: B223330\n");
    System.out.print("提出日: 2022/07/19\n");
    System.out.print("******************************\n");
  }

  // CSVファイルからデータを取得する
  public ArrayList<Food> readCSV(String filename) {
    ArrayList<Food> data = new ArrayList<Food>();

    try {
      br = new BufferedReader(new FileReader(filename));

      String[] buffer;
      String line = br.readLine(); // 最初の行を読み込む
      while ((line = br.readLine()) != null) {
        buffer = line.split(","); // カンマ区切りで配列に格納
        data.add(new Food(buffer[0], Double.parseDouble(buffer[2]), Double.parseDouble(buffer[3]), Double.parseDouble(buffer[5]))); // 食品名，炭水化物，カロリー，タンパク質のみdataに格納
      }

      if (br != null) br.close();
    }
    catch (FileNotFoundException e) {
      System.err.println("File Open Error: Filename = " + filename);
      System.exit(1);
    }
    catch (NumberFormatException e) {
      System.err.println("Number Format Error: Filename = " + filename);
      System.exit(1);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("java Kadai5 food.csv [C/P (C: carbon, P: protein)]");
      System.exit(1);
    }

    Kadai5 kadai = new Kadai5();
    kadai.printMyInfo();

    ArrayList<Food> data = kadai.readCSV(args[0]);
    String mode = args[1]; // C or P

    ArrayList<Double> carbon = new ArrayList<Double>(), calorie = new ArrayList<Double>(), protein = new ArrayList<Double>();

    // dataから炭水化物，カロリー，タンパク質をそれぞれ取り出し，それぞれ別の配列に格納
    for (int i = 0; i < data.size(); i++) {
      carbon.add(data.get(i).getCarbon());
      calorie.add(data.get(i).getCalorie());
      protein.add(data.get(i).getProtein());
    }

    // カロリーを予測したい食品(落花生，絹豆腐，しいたけ)の炭水化物とタンパク質
    ArrayList<Double> rakkasei = new ArrayList<>(List.of(19.6, 26.5));
    ArrayList<Double> kinudouhu = new ArrayList<>(List.of(2.0, 4.0));
    ArrayList<Double> shiitake = new ArrayList<>(List.of(4.9, 3.0));

    // 単回帰
    if (mode.equals("C")) { // 説明変数を炭水化物とする場合
      FoodRegression fr = new FoodRegression(carbon, calorie);
      System.out.println("カロリーを炭水化物で単回帰した場合");

      // 単回帰をおこなう
      fr.doRegression();

      // 結果を出力
      System.out.printf("a = %.5f\n", fr.getA());
      System.out.printf("b = %.5f\n", fr.getB());
      System.out.printf("R2 = %.5f\n" ,fr.computeR2());
      System.out.printf("「落花生」のカロリー予測 = %.5f\n", fr.getA() * rakkasei.get(0) + fr.getB());
      System.out.printf("「絹豆腐」のカロリー予測 = %.5f\n", fr.getA() * kinudouhu.get(0) + fr.getB());
      System.out.printf("「しいたけ」のカロリー予測 = %.5f\n", fr.getA() * shiitake.get(0) + fr.getB());
    }
    else if (mode.equals("P")) { // 説明変数をタンパク質とする場合
      FoodRegression fr = new FoodRegression(protein, calorie);
      System.out.println("カロリーをタンパク質で単回帰した場合");

      // 単回帰をおこなう
      fr.doRegression();

      // 結果を出力
      System.out.printf("a = %.5f\n", fr.getA());
      System.out.printf("b = %.5f\n", fr.getB());
      System.out.printf("R2 = %.5f\n" ,fr.computeR2());
      System.out.printf("「落花生」のカロリー予測 = %.5f\n", fr.getA() * rakkasei.get(1) + fr.getB());
      System.out.printf("「絹豆腐」のカロリー予測 = %.5f\n", fr.getA() * kinudouhu.get(1) + fr.getB());
      System.out.printf("「しいたけ」のカロリー予測 = %.5f\n", fr.getA() * shiitake.get(1) + fr.getB());
    }
    else {
      System.err.println("第二引数はCまたはPにしてください");
      System.exit(1);
    }
  }
}
