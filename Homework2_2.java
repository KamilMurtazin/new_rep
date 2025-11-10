import java.util.Scanner;

public class Homework2_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d |", i);
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%4d", i * j);
			}
		}
	}
}