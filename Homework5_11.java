import java.util.Scanner;

public class Homework5_11 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		boolean validName = text.matches("[A-Z][a-z]{1,14}");
		
		if (validName) {
			System.out.println("Valid user name");
        } else {
            System.out.println("Invalid user name");
        }
	}
}