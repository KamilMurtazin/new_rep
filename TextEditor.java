import java.util.Scanner;

public class Classwork4_1 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String email = scanner.nextLine();
		email.matches("[a-zA-Z0-9\\._\\+\\-]+@[a-z0-9\\-\\.]+[a-z]{2,}");