import java.util.Scanner;

public class Homework3_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int line = scanner.nextInt();
		int column = scanner.nextInt();
		int[][] massive = new int[line][column];
		for (int i = 0; i < line; i ++) {
			for (int j = 0; j < column; j ++) {
				massive[i][j] = scanner.nextInt();	
			}
		}
		boolean result = true;
		for (int i = 0; i < line; i ++) {
			int countOfTrueNums = 0;
			for (int j = 0; j < column; j ++) {
				int num = Math.abs(massive[i][j]);
				int sumOfDigits = 0;
				while (num > 0) {
					sumOfDigits += num % 10;
					num /= 10;
				}
				if (sumOfDigits % 5 == 0) {
					countOfTrueNums ++;
				}
				if (countOfTrueNums >= 2) {
					break;
				}
			}
			if (countOfTrueNums < 2) {
				result = false;
				break;
			}
		}
		System.out.println(result);
	}
}