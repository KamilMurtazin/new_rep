import java.util.Scanner;

public class Homework2_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int power = 1;
		long sum = 0;
		while (power <= n) {
			sum += Math.pow(n, power);
			power += 1;
		}
		System.out.print(sum);
	}
}