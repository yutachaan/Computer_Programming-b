// プログラム3-3: ２分探索木クラス

public class BinaryTree {
  private BinaryTree left;
  private BinaryTree right;
  private int key;
  private int count;

  public BinaryTree() {
    left = right = null;
  }

  public BinaryTree(int key) {
    left = right = null;
    this.key = key;
    this.count = 1;
  }

  public void insert(int key) {
    if (this == null) {
      BinaryTree node = new BinaryTree(key);
      return;
    }

    if (key < this.key) {
      if (left == null) left = new BinaryTree(key);
      else left.insert(key);
    }
    else if (this.key < key) {
      if (right == null) right = new BinaryTree(key);
      else right.insert(key);
    }
    else this.count++;

    return;
  }

  public void print(BinaryTree node) {
    System.out.println("key = " + node.key);
  }

  // 再帰的に２分探索木をトラバース
  public void inOrder(BinaryTree node) {
    if (node != null) {
      inOrder(node.left);
      node.print(node);
      inOrder(node.right);
    }
  }

  public static void main(String[] args) {
    int[] keys = {17, 25, 15, 25, 16, 13, 43, 14};

    BinaryTree root = new BinaryTree(keys[0]);
    for (int i = 1; i < keys.length; i++) root.insert(keys[i]);

    root.inOrder(root);
  }
}
