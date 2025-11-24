import java.util.Scanner;

public class Homework3_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] massive = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if ((j + i) % 2 == 0) { 
					massive[i][j] = 1;
				} else {
					massive[i][j] = 0;
				}
			}
		}
		printMatrix(massive);
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[i].length; j ++) {
				System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}