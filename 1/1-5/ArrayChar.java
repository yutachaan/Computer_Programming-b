// プログラム1-5： ファイル（端末）から1文字ずつ入力して数字の出現回数等をプリントする

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ArrayChar {
  public int fileIO(String inFile) {
    try {
      FileInputStream   fis = new FileInputStream(inFile); // ファイルからバイト単位で読出し
      InputStreamReader isr = new InputStreamReader(fis);  //文字入力ストリーム

      int c;
      int[] digitCount = new int[10]; // 0-9までの数字文字のカウント用
      for (int i = 0; i < 10; i++) digitCount[i] = 0;
      int whiteSpaceCount = 0;
      int otherCharCount  = 0;

      while ((c = isr.read()) != -1) { // EOFまたはC-d(^D)がタイプされるまで
        if (c >= '0' && c <= '9') digitCount[c - '0']++;
        else if (c == ' ' || c == '\n' || c == '\t') whiteSpaceCount++;
        else otherCharCount++;
      }

      String s = null;
      System.out.print("数字文字の出現回数は以下の通りです。\n");
      for (int i = 0; i < 10; i++) {
        s = String.format("　　数字%cは%d回出現しました。\n", i + '0', digitCount[i]);
        System.out.print(s);
      }
      s = String.format("空白文字は%d回出現しました。\n", whiteSpaceCount);
      System.out.print(s);
      s = String.format("それ以外の文字は%d回出現しました。\n", otherCharCount);
      System.out.print(s);

      return 0;
    } catch (Exception e) {
      e.printStackTrace();
      return 1;
    }
  }

  public static void main(String[] args) {
    try {
      ArrayChar ac = new ArrayChar();
      int rc = ac.fileIO(args[0]);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
