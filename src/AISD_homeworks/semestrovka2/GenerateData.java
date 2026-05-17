package AISD_homeworks.semestrovka2;

import java.io.*;
import java.util.Random;

public class GenerateData {
    public static void main(String[] args) throws IOException {
        int[] sz = new int[80];
        for (int i = 0; i < 80; i++) {
            sz[i] = 100 + i * 125;
            if (sz[i] > 10000) sz[i] = 10000;
        }
        Random rnd = new Random(42);
        File d = new File("data");
        if (!d.exists()) d.mkdir();
        for (int x : sz) {
            StringBuffer sb = new StringBuffer(x);
            for (int i = 0; i < x; i++) {
                sb.append((char)('a' + rnd.nextInt(26)));
            }
            String sub;
            if (x >= 10) sub = sb.substring(0, 10);
            else sub = sb.toString();
            PrintWriter wr = new PrintWriter(new FileWriter("data/test_" + x + ".txt"));
            wr.println(sb.toString());
            wr.println(sub);
            wr.close();
        }
        System.out.println("done");
    }
}