// プログラム2-7: 英単語のカウンタクラス

import java.util.*;
import java.io.*;
import java.text.Format;
import java.text.DateFormat;

public class WordToken {
  public String getEnglishTokens(String line) {
    if (line == null || line.length() <= 0) return null;

    int length = line.length();
    String token = "", output = ""; // otuput: 行の中で見つかったトークン列を保持

    int i = 0;
    while (i < length) {
      token = "";
      char c = line.charAt(i);
      while (('A' <= c  && c <= 'Z') || ('a' <= c && c <= 'z')) {
	      if ('A' <= c && c <= 'Z') c = (char)(c - 'A' + 'a');
        token = token + c;

        i++;
        if (i >= length) break;
        c = line.charAt(i);
      }

      if (token.length() >= 1) output = output + " " + token;
      i++;
    }

    return output;
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("java(u) WordToken [ファイル名]");
      System.exit(0);
    }

    WordToken wt = new WordToken();
    Map<String, Integer> wordset = new TreeMap<String, Integer>(); // TreeMap: 結果がソートされる

    try {
      BufferedReader br = new BufferedReader(new FileReader(args[0]));

      String line, tokens;
      while ((line = br.readLine()) != null) {
        tokens = wt.getEnglishTokens(line);
        if (tokens == null) continue;

        String[] result = tokens.split("\\s+");
        for (int i = 0; i < result.length; i++){
          String token = result[i];
          if (token.length() < 1) continue;
          if (wordset.containsKey(token)) {
            int value = wordset.get(token);
            wordset.put(token, ++value);
          }
          else wordset.put(token, 1);
        }
      }

      for (Map.Entry<String, Integer> e : wordset.entrySet()) System.out.println(e.getKey() + " " + e.getValue());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
