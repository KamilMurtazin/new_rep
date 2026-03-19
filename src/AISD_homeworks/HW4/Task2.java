package AISD_homeworks.HW4;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество элементов в массиве: ");
        int count = scan.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Ввведите число в " + i + " ячейку масива:");
            arr[i] = scan.nextInt();
            if (i > 0 && arr[i] < arr[i - 1]) {
                System.out.println("Ошибка: элемент должен быть не меньше предыдущего введите число заново");
                arr[i] = scan.nextInt();
            }
        }
        System.out.println("Массив заполнен, введите число n: ");
        int n = scan.nextInt();
        BinarySearch bs = new BinarySearch();
        int f = bs.findFirst(arr, n);
        int l = bs.findLast(arr, n);
        System.out.println("Индекс первого вхождения, индекс второго вхождения соответственно: " +  f + ", " + l );
    }
}