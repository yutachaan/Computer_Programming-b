// プログラム2-4: Stringクラスでの文字列の交換を利用したソーティング

public class SwapString {
  // i番目とj番目のデータを交換
  public void swap(String[] data, int i, int j){
    String tmp = data[i];
    data[i] = data[j];
    data[j] = tmp;
  }

  public void sortWords(String[] words) {
    if (words == null){
      System.err.println("データがnullです");
      return;
    }

    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (words[i].compareTo(words[j]) > 0) swap(words, i, j);
      }
    }

    return;
  }

  public static void main(String[] args) {
    String[] month = {
      "January", "February", "March", "April",
      "May", "June", "July", "August",
      "September", "October", "November", "December"
    };
    String[] season = {"春", "夏", "秋", "冬"};

    SwapString ss = new SwapString();
    ss.sortWords(month);
    for (int i = 0; i < month.length; i++) System.out.println(month[i]);

    ss.sortWords(season);
    for (int i = 0; i < season.length; i++) System.out.println(season[i]);
  }
}
