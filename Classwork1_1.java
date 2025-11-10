import java.util.Scanner; 

public class Classwork1_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] massiv = new int[a];
		
		for (int i = 0; i < a; i ++) {
			massiv[i] = scanner.nextInt();
		}
		int max = massiv[0];
		for (int i = 1; i < a; i++) {
			if (massiv[i] > max) {
				max = massiv[i];
			}	
		}
		System.out.println(max);
	}
}