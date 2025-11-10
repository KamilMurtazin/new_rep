import java.util.Scanner;

public class Homework2_1 {  
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		while (m != 0) {
			for (int j = 0; j < n; j ++) {
				System.out.print("1 ");
			}
			System.out.println();
			m -= 1; 
		}
	}
}