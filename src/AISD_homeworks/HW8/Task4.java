package AISD_homeworks.HW8;

import java.util.HashMap;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int multiplier = scanner.nextInt();

        long[] numbers = new long[arraySize];
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = scanner.nextInt();
        }

        HashMap<Long, Long> leftCount = new HashMap<>();
        HashMap<Long, Long> rightCount = new HashMap<>();

        // Заполняем rightCount всеми элементами
        for (long num : numbers) {
            rightCount.put(num, rightCount.getOrDefault(num, 0L) + 1);
        }

        long result = 0;

        for (int i = 0; i < arraySize; i++) {
            long currentNum = numbers[i];

            // Удаляем currentNum из rightCount (переносим в left)
            long countInRight = rightCount.get(currentNum);
            if (countInRight == 1) {
                rightCount.remove(currentNum);
            } else {
                rightCount.put(currentNum, countInRight - 1);
            }

            // Проверяем, можем ли составить геометрическую прогрессию
            if (currentNum % multiplier == 0) {
                long prevElement = currentNum / multiplier;
                long nextElement = currentNum * multiplier;

                long leftCountValue = leftCount.getOrDefault(prevElement, 0L);
                long rightCountValue = rightCount.getOrDefault(nextElement, 0L);

                result += leftCountValue * rightCountValue;
            }

            // Добавляем currentNum в leftCount
            leftCount.put(currentNum, leftCount.getOrDefault(currentNum, 0L) + 1);
        }

        System.out.println(result);
    }
}