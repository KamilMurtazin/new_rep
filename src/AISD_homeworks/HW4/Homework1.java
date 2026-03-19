package AISD_homeworks.HW4;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();

        String doubledS = s + s;
        if (s.length() == t.length() && doubledS.contains(t)){
            System.out.println("T is cyclic shift");
        } else {
            System.out.println("T is not a cyclic shift");
        }
    }
}
