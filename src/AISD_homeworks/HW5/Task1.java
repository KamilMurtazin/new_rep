package AISD_homeworks.HW5;

import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args){
        int n = 6;
        int[] x = {1, 2, 3, 5, 5 ,6};
        int result = countUniqueNum(x);
        System.out.println(result);

    }
    public static int countUniqueNum(int[] arr){
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr){
            uniqueSet.add(num);
        }
        return uniqueSet.size();
    }

}
