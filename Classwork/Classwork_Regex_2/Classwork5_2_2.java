import java.util.Scanner;
import java.util.regex.*;

public class Classwork5_2_2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		String logs = """ 
			[ERROR] 2024-01-15: Connection failed 
			[INFO] 2024-01-15: User logged in 
			[DEBUG] 2024-01-15: Processing request 
			[ERROR] 2024-01-15: Database timeout 
		"""; 
		
		Pattern pattern = Pattern.compile("\\[ERROR\\].*");
		Matcher matcher = pattern.matcher(logs);
		while (matcher.find()) {
			System.out.println("Найдены ошибки: " + matcher.group());
		}
	}
}