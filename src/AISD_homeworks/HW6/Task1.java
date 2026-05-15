package AISD_homeworks.HW6;

public class Task1 {
    public static void main(String[] args) {
        int[] numb = {1, 3, 5, 6, 7};
        int target = 6;
        int index = -1;

        for (int i = 0; i < numb.length; i++) {
            if (numb[i] >= target) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            index = numb.length;
        }

        System.out.println(index);
    }
}
