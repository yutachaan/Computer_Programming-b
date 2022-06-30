// プログラム2-1： ファイル（端末）から一行ずつ入力してそのままプリントする

import java.io.*;

public class LineIO {
  public int fileIO(File fileIn, File fileOut) {
    try {
      // 入力ストリームは標準入力かファイル入力かでスイッチ
      BufferedReader br = (fileIn  == null) ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader(fileIn));

      // 出力ストリームは標準出力かファイル出力かでスイッチ
      PrintStream    ps = (fileOut == null) ? System.out : new PrintStream(fileOut);

      String line; // 行単位の文字列を保持
      while ((line = br.readLine()) != null) ps.println(line);

      if (fileIn != null) br.close();
      if (fileOut != null) ps.close();
    }
    catch (Exception e) {
      System.err.println(e);
      return 1;
    }
    return 0;
  }
  public static void main(String[] args) {
    try {
      File fileIn = null, fileOut = null;
      LineIO cio = new LineIO();

      if (args.length == 2){
        fileIn  = new File(args[0]);
        fileOut = new File(args[1]);
      }
      else if (args.length == 1) fileIn = new File(args[0]);
      else if (args.length == 0) ;
      else {
        System.err.println("java LineIO [inFile] [outFile]");
        System.exit(2);
      }

      int rc = cio.fileIO(fileIn, fileOut);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
