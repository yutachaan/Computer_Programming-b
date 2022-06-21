// プログラム1-8: SplitTestクラスを使ったファイル処理

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class SplitTest {
  private BufferedReader br = null;
  private String bookName;
  private String authorName;
  private float price;
  private String priceString;
  private float priceSum = 0.0F;
  private float priceAverage = 0.0F;
  private int dataNum = 0;
  private String ISBN;
  private String year;

  public void openFile(String fileName) {
    try {
      br = new BufferedReader(new FileReader(fileName));
    }
    catch (FileNotFoundException e) {
      System.err.println("ファイルのOpenエラー: ファイル名 = " + fileName);
      System.exit(1);
    }
    catch (Exception e) {
        System.err.println("ファイルのIOエラー: ファイル名 = " + fileName);
        System.exit(1);
    }
  }

  public void closeFile() {
    try {
      if (br != null) br.close();
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }

  public void readRecords() {
    String[] result = null;
    try {
        // 1行目の処理
        String firstLine = br.readLine();
        result = firstLine.split("\\s*,\\s*");

        bookName    = result[0];
        authorName  = result[1];
        priceString = result[2];
        ISBN        = result[3];
        year        = result[4];
        System.out.println(ISBN + "     " + year + "  " + priceString + "   " + authorName + "\t " + bookName);

        // 2行目以降の処理
        String line;
        while ((line = br.readLine()) != null) {
          result = line.split("\\s*,\\s*");

          bookName   = result[0];
          authorName = result[1];
          price      = Float.valueOf(result[2]).floatValue();
          priceSum  += price;
          ISBN       = result[3];
          year       = result[4];

          System.out.printf("%-12s %-5s %5.1f %-8s %-20s\n", ISBN, year, price, authorName, bookName);

          dataNum++;
        }

        priceAverage = priceSum / (float) dataNum;

        System.out.printf("行数 = %d\n", dataNum );
        System.out.printf("値段の平均 = %f\n", priceAverage);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SplitTest csv = new SplitTest();
    csv.openFile("book.csv");
    csv.readRecords();
    csv.closeFile();
  }
}
