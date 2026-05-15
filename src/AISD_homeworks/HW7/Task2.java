package AISD_homeworks.HW7;

public class Task2 {
    public static int getLastDigit(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        int prevPrev = 0;
        int prev = 1;
        int lastDigit = 0;

        for (int i = 2; i <= n; i ++){
            lastDigit = (prevPrev + prev) % 10;
            prevPrev = prev;
            prev = lastDigit;
        }
        return lastDigit;
    }

    public static void main(String[] args){
        System.out.println(getLastDigit(8));
    }
}
