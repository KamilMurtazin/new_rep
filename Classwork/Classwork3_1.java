import java.util.Scanner;

public class Classwork3_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] massive1 = new int[n][m];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				massive1[i][j] = scanner.nextInt();
			}
		}
		int[][] massive2 = new int[n][m];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				massive2[i][j] = massive1[i][j];
			}
		}
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				System.out.print(massive2[i][j] * 2 + " ");
			}
			System.out.println();
		}
	}
}