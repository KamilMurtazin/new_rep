import java.util.Scanner;

public class Homework5_2 {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String sentence = scanner.next();
		
		int countOfVowelLetters = 0;
		int maxOfVowelLetters = 0;
		String currentWord = "";
		String wordWithMaxVowels = "";
		
		for (int i = 0; i < sentence.length(); i ++) {
			char c = sentence.charAt(i);
			currentWord += c;
			
			if (c == 'A' || c == 'E' || c =='Y' || c == 'U' || c == 'I' || c == 'O' || c == 'a' || c == 'e' || c == 'y' || c == 'u' || c == 'i' || c == 'o') {
				countOfVowelLetters ++;
			} else if (c == ' ') {
				if (countOfVowelLetters > maxOfVowelLetters) {
					maxOfVowelLetters = countOfVowelLetters;
					wordWithMaxVowels = currentWord;
				}
				countOfVowelLetters = 0;
			} else {
				continue;
			}
		}
			if (countOfVowelLetters > maxOfVowelLetters) {
				wordWithMaxVowels = currentWord;
        }
		System.out.println(wordWithMaxVowels);
	}
}