package AISD_homeworks.HW7;

public class Task1Fibo {
    public static void main(String[] args){
        int a = 21;
        System.out.println(isFibonacciLinear(a));
    }

    public static boolean isFibonacciLinear(int number) {
        if (number < 0) return false;
        if (number == 0 || number == 1) return true;

        int prev = 0;
        int current = 1;

        while (current < number) {
            int next = prev + current;
            if (next == number) return true;
            prev = current;
            current = next;
        }

        return false;
    }
}
