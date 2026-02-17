import java.util.Scanner;

public class Homework6 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		float x = myScanner.nextFloat();
		float y = myScanner.nextFloat();
		int n = myScanner.nextInt();
		float x1 = Math.abs(x);
		float y1 = Math.abs(y);
		if (Math.pow(x1 * x1 + y1 * y1, 0.5) <= n) {
			System.out.println("Входит в круг");
		} else {
			System.out.println("Не входит в круг");
		}
	}
}