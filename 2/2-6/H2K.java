// プログラム2-6:全角ひらかなを全角カタカナに変換

public class H2K {
  /*
   * ひらがなとカタカナのUnicode上での分布
   *
   * ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞ
   * ただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽ
   * まみむめもゃやゅゆょよらりるれろゎわゐゑをん
   *
   * ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾ
   * タダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポ
   * マミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ
   */

  public static String ZenkakuH2K(String ss) {
    String s = new String(ss), output = "";

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'ぁ' && c <= 'ん') output += (char)(c - 'ぁ' + 'ァ');
    }

    return output;
  }

  public static void main(String[] args) {
	  System.out.println(ZenkakuH2K("ぷろぐらみんぐ"));
  }
}
