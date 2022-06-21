// プログラム1-11： 英語テキストファイル内の単語のカウント（大文字も含む）

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class DictionarySample {
  public static void main(String[] args) {
    int len = args.length;
    if (len != 1) {
      System.err.println("java DictionarySample [file]");
      System.exit(1);
    }
    try {
      BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
      String line = null;
      Map<String, Integer> dictionary = new HashMap<String,Integer>();

      while ((line = reader.readLine()) != null) {
        line = line.replaceAll("[^A-Za-z]", " "); //A-Za-z以外はスペースに置換
        line = line.trim();                                          //両端のスペースを削除
        String[] words = line.split("\\s+");

        // 空行のスキップ
        if (line.equals("")) continue;

        for (String word: words) {
          if (dictionary.containsKey(word)) {
            Integer val = dictionary.get(word);
            dictionary.put(word, val + 1);
          }
          else dictionary.put(word, 1);
        }
      }

      // Map内のすべてのキーと値のペアをプリント
      for (String key: dictionary.keySet()) System.out.println(key + ": " + dictionary.get(key));

      reader.close();
    }
    catch (FileNotFoundException e) {
      System.err.printf("ファイルのOpenエラー: ファイル名=%s\n", args[0]);
      System.exit(1);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
