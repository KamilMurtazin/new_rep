import java.util.Scanner;

public class Homework13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int prevNum = scanner.nextInt();
		int currentNum;
		System.out.println(prevNum);
		while (true) {
			currentNum = scanner.nextInt();
			if (currentNum < prevNum) {
				System.out.println("Mistake");
				break;
			} else {
			System.out.println(currentNum);
			prevNum = currentNum;
			}
		}
	}
}