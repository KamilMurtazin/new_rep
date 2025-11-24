import java.util.Scanner;

public class Homework3_1 {
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
		boolean result = false;
		for (int j = 0; j < column; j ++) {
			int count = 0;
			for (int i = 0; i < line; i ++) {
				if (massive[i][j] % 3 == 0) {
					count ++;
				}
			}
			if (count == line) {
				result = true;
				break;
			}
		}
		System.out.println(result);
	}
}