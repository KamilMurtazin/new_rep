package AISD_homeworks.HW8;

public class Task3 {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = new int[][]{
                {0, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 0}
        };

        int edgeCount = 0;

        for (int[] row : adjacencyMatrix) {
            for (int value : row) {
                if (value == 1) {
                    edgeCount += 2;
                }
            }
        }

        System.out.println(edgeCount - (edgeCount / 2 + 1));
    }
}