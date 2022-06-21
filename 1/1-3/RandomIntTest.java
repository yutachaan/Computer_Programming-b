// プログラム1-3: 乱数で生成した整数をプリント

import java.util.Random; // 標準乱数クラス
import java.util.Date;   // 標準日付と時間を発生するクラス

public class RandomIntTest {
  public static void main(String[] args) {
    int random1, random2, random3;
    Date date1 = new Date();
    Random rand = new Random(date1.getTime()); // 乱数クラスの現在時刻で初期化して生成

    // 0-15の整数を乱数で発生
    random1 = rand.nextInt(16);
    random2 = rand.nextInt(16);
    random3 = rand.nextInt(16);

    System.out.println("第一の乱数は、" + random1 + "です。");
    System.out.println("第二の乱数は、" + random2 + "です。");
    System.out.println("第三の乱数は、" + random3 + "です。");
  }
}
