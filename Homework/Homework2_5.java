import java.util.Scanner;

public class Homework2_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long sum = 0;
		long factorial = 1;
		
		for (int i = 1; i <= n; i ++) {
			factorial *= i;
			sum += factorial;
		}
		System.out.print(sum);
	}
}