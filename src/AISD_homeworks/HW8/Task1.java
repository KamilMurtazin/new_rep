package AISD_homeworks.HW8;
import java.util.HashSet;

public class Task1 {
    public static void main(String[] args) {
        final int WIDTH = 3;
        final int HEIGHT = 3;
        int[][] grid = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        HashSet<Integer>[][] pathSums = new HashSet[HEIGHT][WIDTH];
        pathSums[0][0] = new HashSet<>();
        pathSums[0][0].add(grid[0][0]);

        for (int col = 0; col < WIDTH; col++) {
            for (int row = 0; row < HEIGHT; row++) {
                if (col == 0 && row == 0) continue;
                pathSums[row][col] = new HashSet<>();

                if (col == 0) {
                    // идем сверху (с предыдущей строки)
                    for (int prevSum : pathSums[row - 1][col]) {
                        pathSums[row][col].add(prevSum + grid[row][col]);
                    }
                } else if (row == 0) {
                    // идем слева (с предыдущего столбца)
                    for (int prevSum : pathSums[row][col - 1]) {
                        pathSums[row][col].add(grid[row][col] + prevSum);
                    }
                } else {
                    // идем и сверху, и слева
                    for (int prevSum : pathSums[row - 1][col]) {
                        pathSums[row][col].add(prevSum + grid[row][col]);
                    }
                    for (int prevSum : pathSums[row][col - 1]) {
                        pathSums[row][col].add(grid[row][col] + prevSum);
                    }
                }
            }
        }

        System.out.println(pathSums[HEIGHT - 1][WIDTH - 1].size());
    }
}
