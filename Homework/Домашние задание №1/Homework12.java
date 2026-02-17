import java.util.Scanner;

public class Homework12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int power = 0;
		long binary = 0;
		
		while (a != 0) {
			int remainder = a % 2;
			binary += remainder * Math.pow(10, power);
			a /= 2;
			power ++;
		}
		System.out.println(binary);
	}
}