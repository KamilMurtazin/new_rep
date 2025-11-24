import java.util.Scanner;

public class Homework2 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		float a = myScanner.nextFloat();
		float b = myScanner.nextFloat();
		float max = Math.max(a, b);
		System.out.println(max);
	}
}	