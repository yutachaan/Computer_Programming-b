// プログラム2-5: Arrays配列のソーティングを直接利用した場合

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		String[] month = {
			"January", "February", "March", "April",
			"May", "June", "July", "August",
			"September", "October", "November", "December"
		};
		String[] season = {"春", "夏", "秋", "冬"};

		Arrays.sort(month);
		int i = 0;
		for (String name: month) System.out.println("ソート後:(" + (++i) + ") = " + name);

		Arrays.sort(season);
		i = 0;
		for (String name: season) System.out.println("ソート後:(" + (++i) + ") = " + name);
	}
}
