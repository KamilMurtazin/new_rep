import java.util.Scanner;

public class Homework8 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int k = myScanner.nextInt();
		for (int i = 1; i < 11; i++) {
			System.out.println(i + " * " + k + " = " + k * i);
		}
	}
}