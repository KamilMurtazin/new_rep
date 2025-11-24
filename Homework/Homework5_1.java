import java.util.Scanner;

public class Homework5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean result = true;
        String oldString = scanner.nextLine();
        String newString = "";
		
        for (int i = 0; i < oldString.length(); i++) {
			char c = oldString.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
				if (c >= 'A' && c <= 'Z') {
					c = (char)(c + 32);
				}
			newString += c;
			}
		}
		
		for (int i = 0; i < newString.length() / 2; i ++) {
			if (newString.charAt(i) != newString.charAt(newString.length() - 1 - i)) {
				result = false;
				break;
			}
		}
		
		System.out.println(result);
    }
}