import java.util.Scanner;

public class Homework4 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		float a = myScanner.nextFloat();
		float b = myScanner.nextFloat();
		if (a == b) {
			System.out.println("Они равны");
		} else {
			System.out.println("Не равны");
		}
	}
}