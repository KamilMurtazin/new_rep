import java.util.Scanner;

public class Homework4_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];
		double center = (n - 1) / 2.0;
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
                if (Math.abs(2 * i - n + 1) + Math.abs(2 * j - n + 1) <= n) {
                    matrix[i][j] = 1;
				} else {
					matrix[i][j] = 0;
                }
			}
		}
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				System.out.print(matrix[i][j] + " ");
			}
		System.out.println();
		}
	}
}