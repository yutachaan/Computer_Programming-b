// プログラム1-10  For/Inループの例

import java.util.*;

public class ForInDemo {
  public static void main(String[] args) {
      // SetクラスというCollectionクラスでイタレートさせる
      Set<String> wordset  = new HashSet<String>();
      Set<String> wordset2 = new TreeSet<String>();

      System.out.print("入力：");
      for (String word: args) {
        System.out.print(word + " ");
        wordset.add(word);
        wordset2.add(word);
      }

      System.out.println();

      System.out.print("HashSet:");
      for (String word: wordset)  System.out.print(word + " ");
      System.out.print("\n");

      System.out.print("TreeSet:");
      for (String word: wordset2) System.out.print(word + " ");
      System.out.print("\n");
  }
}
