import java.util.Scanner; 

public class Homework3 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		float a = myScanner.nextFloat();
		float b = myScanner.nextFloat();
		float c = myScanner.nextFloat();
		float max = Math.max(Math.max(a, b), c);
		System.out.println(max);
	}
}