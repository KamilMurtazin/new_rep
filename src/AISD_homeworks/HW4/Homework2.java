package AISD_homeworks.HW4;

public class Homework2 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 4, 5, 6, 7, 8};
        int n = arr.length + 1;

        int maxNum = arr[0];
        int sumOfArrayMembers = 0;

        for (int i = 0; i < arr.length; i ++){
            sumOfArrayMembers += arr[i];
            if (maxNum < arr[i]){
                maxNum = arr[i];
            }
        }

        int sumOfMaxNumArrayMembers = maxNum * (maxNum + 1) / 2;  //арифметическая прогрессия
        System.out.println(sumOfMaxNumArrayMembers - sumOfArrayMembers);
    }
}
