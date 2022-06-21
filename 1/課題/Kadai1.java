/*
  二つのメールファイルに含まれる英単語の出現数をカウントし，出現した総単語数と，各英単語とその出現頻度を出力する

  @作成者: 佐藤 優太
  @提出日: 2022/06/22

  % javacu Kadai1.java
  % javau Kadai1 [ファイル名1] [ファイル名2]
*/


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Kadai1 {
  private BufferedReader br = null;
  private Map<String, Integer> dic = new HashMap<String, Integer>(); // 出現した英単語とその数を保持

  // filenameで指定されたファイルを開く
  public void openFile(String filename) {
    try {
      br = new BufferedReader(new FileReader(filename));
    }
    catch (FileNotFoundException e) {
      System.err.println("File Open Error: Filename = " + filename);
      System.exit(1);
    }
    catch (Exception e) {
      System.err.println("File IO Error: Filename = " + filename);
      System.exit(1);
    }
  }

  // 現在開いているファイルを閉じる
  public void closeFile() {
    try {
      if (br != null) br.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 自分の名前や学籍番号などの情報を出力する(file1, file2: 入力ファイル名)
  public void printMyInfo(String file1, String file2) {
    System.out.print("******************************\n");
    System.out.print("名前: 佐藤 優太\n");
    System.out.print("学籍番号: B223330\n");
    System.out.print("提出日: 2022/06/22\n");
    System.out.printf("入力ファイル名1: %s\n", file1);
    System.out.printf("入力ファイル名2: %s\n", file2);
    System.out.print("******************************\n");
  }

  // 現在開いているファイルに含まれる英単語の出現数をカウントする
  public void countEachWord() {
    try {
      //  EOFまで1行ずつ読み込んで処理
      String line = null;
      while ((line = br.readLine()) != null) {
        line = line.replaceAll("[^a-zA-Z]", " "); // A-Za-z以外はスペースに置換
        line = line.toLowerCase();                                   // 大文字を小文字化する
        line = line.trim();                                          //両端のスペースを削除

        // 空白で区切った結果をwordsに格納
        String[] words = line.split("\\s+");

        // 空行はスキップ
        if (line.equals("")) continue;

        // wordsに格納されている各単語について
        for (String word: words) {
          // すでにdicに追加されているなら出現頻度をインクリメント
          if (dic.containsKey(word)) {
            Integer count = dic.get(word);
            dic.put(word, ++count);
          }
          // まだ追加されていないなら出現頻度を1としてdicに追加
          else dic.put(word, 1);
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  // dicの中身を出力する
  public void printDicResult() {
    try {
      int countAllWord = 0; // 総単語数

      for (String key: dic.keySet()) {
        System.out.println(key + " " + dic.get(key)); // 出現した単語とその出現頻度を出力

        countAllWord += dic.get(key);                 // 総単語数に加算
      }

      System.out.println("総単語数: " + countAllWord);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // 引数の数が2でないなら終了
    if (args.length != 2) {
      System.err.println("java Kadai1 [file1] [file2]");
      System.exit(1);
    }

    try {
      Kadai1 kadai = new Kadai1();

      kadai.printMyInfo(args[0], args[1]);

      // 一つ目のファイルについて処理
      kadai.openFile(args[0]);
      kadai.countEachWord();
      kadai.closeFile();

      // 二つ目のファイルについて処理
      kadai.openFile(args[1]);
      kadai.countEachWord();
      kadai.closeFile();

      kadai.printDicResult();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
