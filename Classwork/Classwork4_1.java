import java.util.Scanner;

public class Classwork4_1 {
    public static boolean allVowels(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        String vowels = "aeiouyAEIOUY";
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != 'A' && c != 'E' && c != 'Y' && c != 'U' && c != 'I' && c != 'O' && c != 'a' && c != 'e' && c != 'y' && c != 'u' && c != 'i' && c != 'o') {
				return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String letter = scanner.next();
		System.out.println(allVowels(letter));
    }
}