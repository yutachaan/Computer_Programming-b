// プログラム3-1: 線形リストのノードクラス

public class Node {
  private String name;
  private Node next;

  public Node(String name, Node next) {
    this.name = name;
    this.next = next;
  }

  public String getName() {
    return name;
  }

  public Node getNext() {
    return next;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void print(String cont) {
    if (cont.equals("")) System.out.print(" " + name); // 引数の文字列が空のとき
    else System.out.print(" " + name + " ->");
  }
}
