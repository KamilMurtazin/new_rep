package AISD_homeworks.semestrovka2;

import java.io.*;
import java.util.*;

public class TestRabinKarp {
    public static void main(String[] args) throws IOException {
        File fdir = new File("data");
        File[] fs = fdir.listFiles();
        if (fs == null) return;
        Arrays.sort(fs, new Comparator<File>() {
            public int compare(File x, File y) {
                int ix = Integer.parseInt(x.getName().replaceAll("\\D", ""));
                int iy = Integer.parseInt(y.getName().replaceAll("\\D", ""));
                return ix - iy;
            }
        });
        PrintWriter pw = new PrintWriter(new FileWriter("res.csv"));
        pw.println("len,ns,cnt");
        for (File f : fs) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String txt = br.readLine();
            String pat = br.readLine();
            br.close();
            int L = txt.length();
            long t1 = System.nanoTime();
            int ans = RabinKarp.find(txt, pat);
            long t2 = System.nanoTime();
            pw.println(L + "," + (t2 - t1) + "," + RabinKarp.steps);
            System.out.println(L + " " + (t2 - t1) + " " + RabinKarp.steps);
        }
        pw.close();
        System.out.println("ok");
    }
}