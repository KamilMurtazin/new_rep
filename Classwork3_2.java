import java.util.Scanner;

public class Classwork3_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] massive1 = new int[n];
		for (int i = 0; i < n; i ++) {	
			massive1[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i ++) {
			
		}
		int[] massive2 = new int[n];
		for (int i = n - 1; i >= 0; i --) {
			massive2[n - 1 - i] = massive1[i];
		}
		for (int i = 0; i < n; i ++) {	
			System.out.print(massive2[i] + " ");
		}
	}
}