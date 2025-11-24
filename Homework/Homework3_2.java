import java.util.Scanner;

public class Homework3_2 {
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
			int countDigitNum = 0;
			for (int j = 0; j < column; j ++) {
				int num = Math.abs(massive[i][j]);
				boolean allDigitsEven = true;
				if (num == 0) {
					allDigitsEven = true;
				} else {
					while (num > 0) {
						int lastdigit = num % 10;
						if (lastdigit % 2 != 0) {
							allDigitsEven = false;
							break;
						}
						num /= 10;
					}
				}
				if (allDigitsEven) {
					countDigitNum ++;
				}
			}
			if (countDigitNum != 1) {
				result = false;
				break;
			}
		}
		System.out.println(result);
	}
}