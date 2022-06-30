// プログラム2-8: 多次元配列クラス

public class MultiDimensionalArray {
  public static void main(String[] args) {
    int[][] result = new int[100][];
    for (int i = 0; i < 100; i++) result[i] = new int[5];

    System.out.println("配列resultの大きさ = " + result.length);
    for (int i = 0; i < 5; i++) System.out.printf("配列result[%d]の大きさ = %d\n", i, result[i].length);
    System.out.print("\n");

    int[][] products = {
    {0},
    {0, 1},
    {0, 2, 4},
    {0, 3, 6, 9},
    {0, 4, 8, 12, 16}
    };

    System.out.println("配列productsの大きさ = " + products.length);
    for (int i = 0; i < products.length; i++) System.out.printf("配列products[%d]の大きさ = %d\n", i, products[i].length);
  }
}
