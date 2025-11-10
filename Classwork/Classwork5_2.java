import java.util.Scanner;
import java.util.regex.*;

public class Classwork5_2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		
		Matcher matcher = Pattern.compile("\".*?\"").matcher(text);
		while (matcher.find()) {
            System.out.println("Найдено: " + matcher.group());
		}
		boolean validDate = text.matches("(0[1-9]|[12]\\d|3[01])\\.(0[1-9]|1[0-2])\\.(19|20)\\d{2}");
		if (validDate) {
			System.out.println("Valid date");
		} else {
            System.out.println("Invalid date");
        }
		
		boolean title = text.matches("[A-Z][a-z]{1,}");
		if (title) {
			System.out.println("Title exist");
        } else {
            System.out.println("Title didn't exist");
        }
		int countOfNum = 0;;
		for (int i = 0; i < text.length(); i ++) {
			char c = text.charAt(i);
			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
				countOfNum ++;
			}
		}
		System.out.println(countOfNum);
	}
}