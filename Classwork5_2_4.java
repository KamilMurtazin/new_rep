import java.util.Scanner;
import java.util.regex.*;

public class Classwork5_2_4 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		Pattern pattern = Pattern.compile(".*?;");
		Matcher matcher = pattern.matcher(text + ";");
		while (matcher.find()) {
			System.out.println("Найдено: " + matcher.group());
		}
	}
}