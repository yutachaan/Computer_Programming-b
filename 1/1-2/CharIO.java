// プログラム1-2： ファイル（端末）から1文字ずつ入力してそのままプリントする

import java.io.*;

public class CharIO {
  public int fileIO() {
    try {
      DataInputStream   in = new DataInputStream(System.in);
      DataOutputStream out = new DataOutputStream(System.out);

      int c;
      while (true) {
        c = in.readChar();
        out.writeChar(c);
      }
    } catch (EOFException e) {
      return 0;
    } catch (IOException e) {
      System.err.println(e);
      return 1;
    }
  }

  public static void main(String[] args) {
    try {
      CharIO cio = new CharIO();
      int rc = cio.fileIO();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
