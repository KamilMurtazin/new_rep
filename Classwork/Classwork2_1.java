import java.util.Scanner;

public class Classwork2_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int line = scanner.nextInt();
		int column = scanner.nextInt();
		int[][] massive = new int[line][column];
		boolean result = true;
		for (int i = 0; i < line; i ++) {
			for (int j = 0; j < column; j ++) {
				System.out.println("Введи число для индекса [" + line + "] [" + column + "]");
				massive[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 0; i < line; i ++) {
			for (int j = 0; j < column; j ++) {
				System.out.println(massive[i][j] + " ");
			}
			System.out.println();
		}
		int num = 0;
		int sum;
		for (int i = 0; i < line; i ++) {
			for (int j = 0; j < column; j ++) {
				sum = 0;
				num = massive[i][j];
				while (num > 0) {
					sum += num % 10;
					num /= 10;
				}
				if (sum == 10) {
					count ++;
				}
				if (count != 1) {
					break;
					result = false;
				}
			}
			count = 0
		}
		if (result) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}