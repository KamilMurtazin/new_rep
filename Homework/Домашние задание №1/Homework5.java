import java.util.Scanner;

public class Homework5 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		float x = myScanner.nextFloat();
		float y = myScanner.nextFloat();
		int n = myScanner.nextInt();
		int n2 = n * (-1);
		if ((n2 / 2.0f <= x && x <= n / 2.0f) && (n2 / 2.0f <= y && y <= n / 2.0f)) {
			System.out.println("Попадает в квадрат");
		} else {
			System.out.println("Не попадает в квадрат");
		}
	}
}