import java.util.Scanner;
import java.util.regex.*;

public class Classwork5_3 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст для анализа:");
		String text = scanner.nextLine();
		analyzeWord(text);
		analyzeNumber(text);
		analyzeContacts(text);
		analyzeOfSymbols(text);
		analyzeSentences(text);
		
	}
	public static void analyzeNumber(String text){
		Pattern allNumPattern = Pattern.compile("(^|\\s)((\\d{1,}[,\\.]\\d{1,})|(\\d{1,}))");
		Matcher allNumMatcher = allNumPattern.matcher(text);
		boolean foundAllNum = false;
		System.out.println("Найденные числовые данные:");
		while (allNumMatcher.find()) {
			System.out.println("  " + allNumMatcher.group());
			foundAllNum = true;
		}
		if (!foundAllNum) {
			System.out.println(" Числовые данные не найдены");
		}
		
		Pattern dollarPattern = Pattern.compile("((\\d+)|((\\d+)[,\\.]\\d+))\\$");
		Matcher dollarMatcher = dollarPattern.matcher(text);
		boolean foundDollar = false;
		System.out.println("Найденные суммы продаж");
		while (dollarMatcher.find()){
			System.out.println("  " + dollarMatcher.group());
			foundDollar = true;
		}
		if (!foundDollar){
			System.out.println("Суммы продаж не найдены");
		}
	}
	public static void analyzeContacts(String text) {
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9\\._\\+\\-]+@[a-z0-9\\-\\.]+[a-z]{2,}");
		Matcher emailMatcher = emailPattern.matcher(text);
		boolean foundEmails = false;
        System.out.println("Найденные email:");
		while (emailMatcher.find()) {
			System.out.println("  " + emailMatcher.group());
			foundEmails = true;
		}
		if (!foundEmails){
			System.out.println("  Email-адреса не найдены");
		}
		
		Pattern phonePattern = Pattern.compile("\\+\\d{11}");
		Matcher phoneMatcher = phonePattern.matcher(text);
		boolean foundPhones = false;
        System.out.println("Найденные номера телефонов:");
		while (phoneMatcher.find()) {
			System.out.println("  " + phoneMatcher.group());
			foundPhones = true;
		}
		if (!foundPhones) {
            System.out.println("  Номера телефонов не найдены");
        }
	}
	public static void analyzeSentences(String text){
		Pattern sentecesPattern = Pattern.compile("[\\.!?]\\s");
		Matcher sentencesMatcher = sentecesPattern.matcher(text);
		int countOfSentences = 1;
		float totalLength = text.length();
		while (sentencesMatcher.find()){
			countOfSentences ++;
			totalLength -= 2;
		}
		System.out.println("Количество предложений");
		System.out.println("  " + (countOfSentences));
		System.out.println("Средняя длина предложения");
		System.out.println("  " + totalLength / countOfSentences);
	}
	public static void analyzeWord(String text){
		Pattern wordPattern = Pattern.compile("[a-zA-zа-яА-Я0-9\\@\\.]+");
		Matcher wordMatcher = wordPattern.matcher(text);
		int countOfWords = 0;
		String[] uniqueWords = new String[text.length()];
		String longestWord = "";
		int uniqueCount = 0; 
		while (wordMatcher.find()){
			countOfWords ++;
			String word = wordMatcher.group();
			if (word.length() > longestWord.length()){
				longestWord = word;
			}
			boolean isUnique = true;
			for (int i = 0; i < uniqueCount; i ++) {
				if (uniqueWords[i].equals(word)) {
					isUnique = false;
					break;
				}
			}
			if (isUnique && uniqueCount < uniqueWords.length) {
				uniqueWords[uniqueCount++] = word;
			}
		}
		
		System.out.println("Количество слов");
		System.out.println("  " + countOfWords);
		System.out.println("Количество уникальных слов");
		System.out.println("  " + uniqueCount);
		System.out.println("Самое длинное слово");
		System.out.println("  " + longestWord);
	}
	public static void analyzeOfSymbols(String text){
		Pattern symbolPattern = Pattern.compile("[a-zA-Zа-яА-Я0-9]|\\s");
		Matcher symbolMatcher = symbolPattern.matcher(text);
		int countOfAllSymbols = 0;
		int countOfScecialSymbols = 0;
		int countOfLetterDigitSpace = 0;
		while (symbolMatcher.find()) {
			countOfLetterDigitSpace ++;
		}
		for (int i = 0; i < text.length(); i ++){
			char c = text.charAt(i);
			if (c != ' ') {
				countOfAllSymbols ++;
			}
		}
		countOfScecialSymbols = countOfAllSymbols - countOfLetterDigitSpace;
		System.out.println("Количество символов");
		System.out.println("  " + countOfAllSymbols);
		System.out.println("Количество букв, цифр, пробелов");
		System.out.println("  " + countOfLetterDigitSpace);
		System.out.println("Количество специальных символов");
		System.out.println("  " + countOfScecialSymbols);
	}
}