import java.util.Scanner;

public class Homework5_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
		int n2 = 1;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			n2 *= 6;
		}

        for (int i = 0; i < n2; i++) {
			counter ++;
			System.out.println(inttostring(i, n));
		}
		System.out.println(counter);
    }
    public static String inttostring(int n, int length) {
        String b = "aeyuio";
        String ret = "";
        for (int i = 0; i < length; i++) {
            ret = b.charAt(n % 6) + ret;
            n /= 6;
        }
        return ret;
    }
}