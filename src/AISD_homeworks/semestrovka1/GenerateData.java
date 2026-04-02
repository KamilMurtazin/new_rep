package AISD_homeworks.semestrovka1;

import java.io.*;
import java.util.Random;

public class GenerateData {
    public static void main(String[] args) throws IOException {
        int[] sizes = new int[50];
        for (int i = 0; i < 50; i++) {
            sizes[i] = 100 + i * 200;
        }

        Random rand = new Random(42);
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();

        for (int size : sizes) {
            int[] keys = new int[size];
            for (int i = 0; i < size; i++) {
                keys[i] = rand.nextInt(size * 10);
            }

            PrintWriter writer = new PrintWriter(new FileWriter("data/set_" + size + ".txt"));
            for (int key : keys) {
                writer.println(key);
            }
            writer.close();
        }

        System.out.println("Создано 50 наборов в папке data");
    }
}