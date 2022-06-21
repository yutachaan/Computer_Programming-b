import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Kadai1 {
  private BufferedReader br = null;

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

  public void closeFile() {
    try {
      if (br != null) br.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void printMyInfo() {
    System.out.print("名前: 佐藤 優太\n");
    System.out.print("学籍番号: B223330\n");
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("java Kadai1 [file1] [file2]");
      System.exit(1);
    }

    try {
      Kadai1 kadai = new Kadai1();

      kadai.printMyInfo();
      System.out.printf("file1: %s\n", args[0]);
      System.out.printf("file2: %s\n", args[1]);

      kadai.openFile(args[0]);
      kadai.closeFile();

      kadai.openFile(args[1]);
      kadai.closeFile();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
