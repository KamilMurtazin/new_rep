import java.util.Scanner;

public class Homework4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] array = new int[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int pr = 0;
        for (int j = 0; j < column; j++) {
            int same = 1;
            int frsum = -1;

            for (int i = 0; i < line; i++) {
                int num = array[i][j];
                if (num < 0) {
                    num = num * (-1);
                }
                int sum = 0;
                int temp = num;
                while (temp > 0) {
                    sum = sum + (temp % 10);
                    temp = temp / 10;
                }
                if (i == 0) {
                    frsum = sum;
                } else {
                    if (sum != frsum) {
                        same = 0;
                        break;
                    }
                }
            }
            if (same == 1 && frsum != -1) {
                pr = 1;
                break;
            }
        }   
        if (pr == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}