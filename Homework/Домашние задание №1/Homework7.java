import java.util.Scanner;

public class Homework7 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		float x = myScanner.nextFloat();
		float y = myScanner.nextFloat();
		double dist = Math.pow(x * x + y * y, 0.5);
		if (Math.ceil(dist) <= 10) {
			System.out.println((int)Math.ceil(dist));
		} else {
			System.out.println("missed");
		}
	}
}