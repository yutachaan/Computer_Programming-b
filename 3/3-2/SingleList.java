// プログラム3-2: 線形リストの生成と動的修正

public class SingleList {
  private Node head;
  private Node tail;
  private long size;

  public SingleList(){
    head = tail = null;
    size = 0L;
  }

  // リストに昇順に挿入
  public void insert(String name) {
    if (head == null) {
      head = tail = new Node(name, null);
      size++;
      return;
    }

    Node p1 = head; // 今見ているノード
    Node p2 = null; // 今見ているノードの次のノード
    Node temp = new Node(name, null); // 新規ノード
    Node q = null; // 前のノード保持用
    size++;

    while (p1 != null) {
      p2 = p1.getNext();
      q = p1;

      if (p2 == null) {
        // 末尾に挿入
        q.setNext(temp);
        tail = temp;
        return;
      }

      else if (p1.getName().compareTo(name) > 0) {
        if (p1 == head) {
          // 線形リストの先頭に挿入
          head = temp;
          head.setNext(p1);
          return;
        }
        else {
          System.err.println("Incredible!（ありえない）");
          return;
        }
      }
      else if (p1.getName().compareTo(name) < 0 && p2.getName().compareTo(name) >= 0) {
        // p1とp2の間に挿入
        p1.setNext(temp);
        temp.setNext(p2);
        return;
      }

      p1 = p1.getNext();
    }
  }

  public void print() {
    Node p = head;
    while (p != null) {
      if (p.getNext() != null) p.print("something");
      else p.print("");

      p = p.getNext();
    }

    System.out.print("\n線形リストのサイズは" + size + "です\n");
  }

  public static void main(String[] args) {
    String[] names = {"高橋", "鈴木", "佐藤", "山田"};

    System.out.println("最初の順序");
    for (int i = 0; i < names.length; i++) {
      System.out.print(" " + names[i]);
      if (i != names.length - 1) System.out.print(" ->");
      else System.out.print("\n");
    }

    SingleList sl = new SingleList();
    for (int i = 0; i < names.length; i++) sl.insert(names[i]);

    System.out.println("線形リスト作成後の順序");
    sl.print();

    sl.insert("田中");
    sl.print();
  }
}
