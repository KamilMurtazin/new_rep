import java.util.Scanner;

public class Homework2_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = 0;
		int power = 1;
		while (power <= n) {
			sum += Math.pow(2, power);
			power ++;
		}
		System.out.println(sum);
	}
}