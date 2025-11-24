import java.util.Scanner;

public class Homework10 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int a = myScanner.nextInt();
		int reversed = 0;
		
		while (a != 0) {
			int lastnum = a % 10;
			reversed = reversed * 10 + lastnum;
			a /= 10;
		}
		System.out.println(reversed);
	}
}