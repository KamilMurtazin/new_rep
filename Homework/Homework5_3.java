import java.util.Scanner;

public class Homework5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int line = scanner.nextInt();
		int column = scanner.nextInt();
        String[][] currentArray = new String[line][column];
		String[][] newArray = new String[column][line];
        
        for (int i = 0; i < line; i++) {
			for (int j = 0; j < column; j++) {
				currentArray[i][j] = scanner.next();
				newArray[j][i] = currentArray[i][j];
			}
        }
		boolean result = true;
		int countOfVowelWords = 0;
		int linesWithVowelWords = 0;
		
		for (int j = 0; j < column; j++) {
			for (int i = 0; i < line; i++) {
				for (int v = newArray[j][i].length() - 1; v < newArray[j][i].length(); v++) {
					
					char last1 = newArray[j][i].charAt(v);
					if (last1 == 'A' || last1 == 'E' || last1 == 'Y' || last1 == 'U' || last1 == 'I' || last1 == 'O' || last1 == 'a' || last1 == 'e' || last1 == 'y' || last1 == 'u' || last1 == 'i' || last1 == 'o') {
						countOfVowelWords ++;
					}
					
				}
			}
			if (countOfVowelWords < 1) {
					result = false;
					break;
			}
			countOfVowelWords = 0;
		}
		System.out.println(result);
    }
}