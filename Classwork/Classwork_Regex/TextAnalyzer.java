import java.util.Scanner;
import java.util.regex.*;

public class TextAnalyzer {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		
		findEmails(text);
        findDates(text);
        findCapitalizedWords(text);
        countDigits(text);
	}
	
	public static void findEmails(String text) {	
		String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Email-адреса:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println("Найден email: " + matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("Email-адреса не найдены");
        }
	}
	
	public static void findDates(String text) {	
		String dateRegex = "(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(19|20)[0-9]{2}";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Даты:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println("Найдена дата: " + matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("Даты не найдены");
        }
	}	
	
	public static void findCapitalizedWords(String text) {
		String capitalizedRegex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(capitalizedRegex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Слова с заглавной буквы:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println("Найдено слово: " + matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("Слова с заглавной буквы не найдены");
        }
	}
	public static void countDigits(String text) {
		int countOfNum = 0;;
		for (int i = 0; i < text.length(); i ++) {
			char c = text.charAt(i);
			if (c >= '0' && c <= '9'){
				countOfNum ++;
			}
		}
		System.out.println("Общее количество цифр: " + countOfNum);
	}
}