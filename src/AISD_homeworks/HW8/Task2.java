package AISD_homeworks.HW8;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 2, 1, 2, 3, 4};
        int[] longestEndingHere = new int[numbers.length];

        for (int i = numbers.length - 1; i >= 0; i--) {
            int bestLength = 1;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > numbers[i]) {
                    if (longestEndingHere[j] + 1 > bestLength) {
                        bestLength = longestEndingHere[j] + 1;
                    }
                }
            }
            longestEndingHere[i] = bestLength;
        }

        System.out.println(Arrays.stream(longestEndingHere).max().stream().toArray()[0]);
    }
}