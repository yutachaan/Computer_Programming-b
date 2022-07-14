/*
  各種図形の発生や PostScriptへの出力を制御する

  @作成者: 佐藤 優太
  @提出日: 2022/07/14

  % javacu Kadai4.java
  % javau Kadai4 [出力するpsファイル名] [生成する図形の数]
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

// メインクラス
public class Kadai4 {
  final static double XRANGE = 600; // X方向のキャンバスサイズ
  final static double YRANGE = 800; // Y方向のキャンバスサイズ
  final static double MAXLEN = 200; // 半径・正方形の1辺の最大値

  // 自分の名前や学籍番号などの情報を出力する
  public void printMyInfo(PrintStream cout, String file) {
    cout.print("%%!PS\n");
    cout.print("%% ******************************\n");
    cout.print("%% 名前: 佐藤 優太\n");
    cout.print("%% 学籍番号: B223330\n");
    cout.print("%% 提出日: 2022/07/14\n");
    cout.printf("%% ファイル名: %s\n", file);
    cout.print("%% ******************************\n\n");
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("第一引数にPostScriptファイル名，第二引数に生成する図形の数を指定してください");
      System.exit(1);
    }

    ArrayList<Shape2D> list = new ArrayList<Shape2D>(); // 生成した図形データを保持
    Shape2D shape = null;

    Date date   = new Date();
    Random rand = new Random(date.getTime());

    try {
      int n = Integer.valueOf(args[1]).intValue(); // 生成する図形の数
      if (n < 10 || n > 50) {
        System.err.println("図形の総数は10から50の間の数にしてください");
        System.exit(1);
      }

      for (int i = 0; i < n; i++) {
        Coord2 v1 = new Coord2(rand.nextDouble(XRANGE), rand.nextDouble(YRANGE)); // 1点目を乱数で生成
        Color c = new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()); // 色を乱数で生成

        int figType = rand.nextInt(3); // 図形の種類を乱数で決定(0: 三角形， 1: 正方形， 2: 円)
        switch (figType) {
          case 0: // 三角形を生成
            Coord2 v2 = new Coord2(rand.nextDouble(XRANGE), rand.nextDouble(YRANGE)); // 2点目を乱数で生成
            Coord2 v3 = new Coord2(rand.nextDouble(XRANGE), rand.nextDouble(YRANGE)); // 3点目を乱数で生成
            shape = new Triangle(v1, v2, v3, c);
            break;
          case 1: // 正方形を生成
            double w = rand.nextDouble(MAXLEN); // 1辺の長さを乱数で決定
            shape = new Square(v1, w, c);
            break;
          case 2: // 円を生成
            double r = rand.nextDouble(MAXLEN); // 半径を乱数で決定
            shape = new Circle(v1, r, c);
            break;
        }

        list.add(shape);
      }

      Kadai4 kadai = new Kadai4();
      PrintStream cout = new PrintStream(args[0], "UTF-8");

      // psファイルのヘッダーを出力
      kadai.printMyInfo(cout, args[0]);

      double areaSum = 0, perimSum = 0; // 面積の総和と周囲長の総和
      for (int i = 0; i < list.size(); i++){
        cout.println("%% " + (i + 1) + "番目の図形");
        list.get(i).psPrint(cout); // 派生クラスに応じてpsファイルに出力

        areaSum  += list.get(i).area();
        perimSum += list.get(i).perimeter();
      }

      cout.printf("%% 総面積 = %.3f\n", areaSum);
      cout.printf("%% 総長 = %.3f\n", perimSum);
      cout.printf("%% 総面積/総長比 = %.3f\n", areaSum / perimSum);
      cout.printf("%% 図形総数 = %d\n\n", n);
      cout.printf("showpage\n");
    }
    catch (NumberFormatException e) {
      System.err.println("二番目の引数には10〜50の間の整数にしてください");
      System.exit(1);
    }
    catch (FileNotFoundException e) {
      System.err.println("ファイル" + args[0] + "が見つかりません");
      System.exit(1);
    }
    catch (UnsupportedEncodingException e) {
      System.err.println("UTF-8符号はサポートされていません");
      System.exit(1);
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
