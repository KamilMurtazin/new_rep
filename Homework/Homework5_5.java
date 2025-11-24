import java.util.Scanner;

public class Homework5_5 {
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

		for (int j = 0; j < column; j++) {
			for (int i = 0; i < line; i++) {
				
				System.out.print(newArray[j][i] + " ");
			}
		System.out.println();
		}
    }
}