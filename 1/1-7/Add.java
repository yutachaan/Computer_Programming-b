// プログラム1-7: Scannerクラスを使った、インタラクティブな足し算

import java.util.Scanner;

public class Add {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number1, number2, sum;

		System.out.print("第一の整数を入力してください  >");
		number1 = input.nextInt();

		System.out.print("第二の整数を入力してください  >");
		number2 = input.nextInt();

		sum = number1 + number2;

		System.out.printf("足し算結果 = %d\n", sum);
	}
}
