import java.util.Scanner;

public class Homework4_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] massive = new int[n][n];
		int m, m1;
		if (n % 2 == 0) {
			m = n / 2;
			m1 = m - 1;
		} else {
			m = n / 2;
			m1 = m;
		}
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (i == m || i == m1 || j == m || j == m1) {
					massive[i][j] = 1;
				} else {
					massive[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < n; i ++)	{
			for (int j = 0; j < n; j ++) {
				System.out.print(massive[i][j] + " ");
			}
			System.out.println();
		}
	}
}