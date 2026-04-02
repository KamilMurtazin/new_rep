package AISD_homeworks.semestrovka1;

import java.io.*;
import java.util.*;

public class TestRBTree {
    public static void main(String[] args) throws IOException {
        int[] sizes = new int[50];
        for (int i = 0; i < 50; i++) {
            sizes[i] = 100 + i * 200;
        }

        int runs = 5;

        System.out.println("size\tput_ns\tget_ns\tremove_ns");

        for (int size : sizes) {
            int[] keys = new int[size];
            Scanner scanner = new Scanner(new File("data/set_" + size + ".txt"));
            for (int i = 0; i < size; i++) {
                keys[i] = scanner.nextInt();
            }
            scanner.close();

            long totalPut = 0;
            long totalGet = 0;
            long totalRemove = 0;

            for (int run = 0; run < runs; run++) {
                RBTree<Integer, String> tree = new RBTree<>();

                long start = System.nanoTime();
                for (int key : keys) {
                    tree.put(key, "v");
                }
                totalPut += System.nanoTime() - start;

                start = System.nanoTime();
                for (int key : keys) {
                    tree.get(key);
                }
                totalGet += System.nanoTime() - start;

                start = System.nanoTime();
                for (int key : keys) {
                    tree.remove(key);
                }
                totalRemove += System.nanoTime() - start;
            }

            System.out.println(size + "\t" + (totalPut / runs) + "\t" + (totalGet / runs) + "\t" + (totalRemove / runs));
        }
    }
}