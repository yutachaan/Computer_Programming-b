// プログラム2-3: Stringクラスでの文字の一部検索

import java.util.Scanner;

public class SubString {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("文字列を入力してください  > ");
		String s1 = input.next();

		System.out.print("検索したい部分文字列を入力してください  > ");
		String s2 = input.next();

		if (s1.indexOf(s2) >= 0){ //文字列s1にs2が含まれれば0以上を返す
			int position = s1.indexOf(s2); // s2文字列が開始する位置
			int length   = s2.length();
			String sub = s1.substring(position, position + length); // 部分文字列の取り出し

			int lastIndex = 0, count = 0;
			while (lastIndex != -1) {
				lastIndex = s1.indexOf(sub, lastIndex);
				if (lastIndex != -1) {
					count++;
					lastIndex += sub.length();
				}
			}

			System.out.println(s1 + " に部分文字列『" + sub + "』が" + count + "回、含まれます");
		}
		else System.out.println(s1 + " に部分文字列『" + s2 + "』は含まれません");
	}
}
