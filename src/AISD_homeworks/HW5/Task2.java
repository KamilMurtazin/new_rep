package AISD_homeworks.HW5;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args){
        int[] arr1 = {1, 0, 2, 0, 1, 2, 0};
        System.out.println("Исходный массив: " + Arrays.toString(arr1));
        Sort(arr1);
        System.out.println("Отсортированный: " + Arrays.toString(arr1));
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void Sort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high){
            if (arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1){
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
}
