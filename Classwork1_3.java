import java.util.Scanner;

public class Classwork1_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] massiv = new int[n];
		for (int i = 0; i < n; i++) {
			massiv[i] = scan.nextInt();
		}
		int otric = 0;
		for (int i = 0; i < n; i++) {
			if (massiv[i] < 0) {
			otric += 1;
			}
		}
		if (otric != 0) {
			System.out.println("+");
		} else {
		System.out.println("+");
		}
	}
}