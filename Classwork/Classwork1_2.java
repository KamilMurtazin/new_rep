import java.util.Scanner;

public class Classwork1_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lenmass1 = scanner.nextInt();
		int lenmass2 = scanner.nextInt();
		if (lenmass1 != lenmass2) {
			System.out.println("False");
		} 
		int[] mass1 = new int[lenmass1];
		int[] mass2 = new int[lenmass1];
		for (int i = 0; i < lenmass1; i ++) {
			mass1[i] = scanner.nextInt();
		}
		for (int i = 0; i < lenmass1; i ++) {
			mass2[i] = scanner.nextInt();
		}
		boolean result = true;
		for (int i = 0; i < lenmass1; i ++) {
			if (mass1[i] != mass2[i]) { 
				result = false;
				break;
			}
		}
		if (result == true) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}