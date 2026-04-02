package AISD_homeworks.HW5;

import java.util.Arrays;
import java.util.Comparator;

public class Task3 {
    public static void main(String[] args) {
        String[] arr = {"BANANA", "Apple", "apple", "banana", "appple", "Apple"};

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                int minLength = Math.min(a.length(), b.length());
                for (int i = 0; i < minLength; i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return a.length() - b.length();
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}