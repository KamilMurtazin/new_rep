package AISD_homeworks.HW6;

public class Task3 {
    public static void main(String[] args) {
        String s = "собака";
        System.out.println(getFibonacciCharsSimple(s)); // ожидается "собаа"
    }
    public static String getFibonacciCharsSimple(String s) {
        int n = s.length();
        String result = "";
        int a = 0, b = 1;

        while (a < n) {
            result += s.charAt(a);
            int next = a + b;
            a = b;
            b = next;
        }

        return result;
    }
}
