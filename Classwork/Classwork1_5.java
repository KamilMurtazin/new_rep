import java.util.Scanner;

public class Classwork1_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lenmass = scanner.nextInt();
		int[] massive = new int[lenmass];
		for (int i = 0; i < lenmass; i ++) {
			massive[i] = scanner.nextInt();
		}
		boolean result = true;
		for (int i = 0; i < lenmass; i ++) { 
			if (massive[i] > 0) {
				if ("2" not in massive[i] || "4" not in massive[i] || "6" not in massive[i] || "8" not in massive[i] ) {
					result = false;
				} else {
					result = true;
					break;
				}
			}
			if (massive[i] < 0) {
				continue;
			}
		}
		if (result == true) {
			System.out.println("True");
		} else {
			System.out.print("False");
		}
	}
}