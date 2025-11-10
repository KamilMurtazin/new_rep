import java.util.Scanner;

public class Homework2_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		float x = scanner.nextFloat();
		float power = 1;
		long factorial = 1;
		float sum = 0.0f;
		for (int i = 1; i <= n; i ++) {
			factorial *= i;
			power *= x;
			sum += factorial * power;
		}
		System.out.println(sum);
	}
}