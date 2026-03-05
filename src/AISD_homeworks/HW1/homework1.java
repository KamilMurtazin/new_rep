package AISD_homeworks.HW1;
import java.util.Scanner;

public class homework1 {
    public static int nod(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 1 || b == 1) return 1;
        if (a == b) return a;
        if (a == 0) return b; 
        if (b == 0) return a;

        if (a < b){
            int c = a;
            a = b;
            b = c;
        }

        while (b != 0){
            int ost = a % b;
            a = b;
            b = ost;
            if (a == 1) return 1;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = nod(a, b);
        System.out.println(result);
    }
}

