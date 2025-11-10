import java.util.Scanner;
import java.util.regex.*;

public class Classwork5_2_3 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		String text1 = """
            <div class="product">
                <h3>Телефон</h3>
                <p>Цена: 20000 руб</p>
            </div>
            <div class="product">
                <h3>Ноутбук</h3> 
                <p>Цена: 50000 руб</p>
            </div>
            """;
		Matcher matcher = Pattern.compile("<h3>.*?</h3>").matcher(text1);
		while (matcher.find()) {
            System.out.println("Найдено: " + matcher.group());
		}
		
	}
}