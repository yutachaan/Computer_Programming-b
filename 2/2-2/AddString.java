// プログラム2-2: Stringクラスでの文字連結

import java.util.Scanner;

public class AddString {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("第一の文字列を入力してください  > ");
		String s1 = input.next(); // 文字列として読込む

		System.out.print("第二の文字列を入力してください  > ");
		String s2 = input.next();

		String sum = s1 + s2;

		System.out.printf("連結結果 = %s\n", sum);
	}
}
