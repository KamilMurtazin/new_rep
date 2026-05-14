package IIP_homeworks.part4.classwork4_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class LongAnalyzerMain {
    public static void main(String[] args) throws Exception {

        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Downloads\\access.log"));
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line);
        }
        br.close();

        long start1 = System.currentTimeMillis();
        int singleErrors = 0, singleApi = 0;
        for (int i = 0; i < lines.size(); i++) {
            String l = lines.get(i);
            if (l.contains("ERROR")) singleErrors++;
            if (l.contains("/api/users")) singleApi++;
        }
        long time1 = System.currentTimeMillis() - start1;

        long start2 = System.currentTimeMillis();
        int chunkSize = lines.size() / 4;
        List<LogAnalyzer> analyzers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int from = i * chunkSize;
            int to = (i == 3) ? lines.size() : (i + 1) * chunkSize;
            LogAnalyzer la = new LogAnalyzer(lines.subList(from, to));
            analyzers.add(la);
            Thread t = new Thread(la);
            threads.add(t);
            t.start();
        }

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
        }

        int totalErrors = 0, totalApi = 0;
        for (int i = 0; i < analyzers.size(); i++) {
            totalErrors += analyzers.get(i).errorCount;
            totalApi += analyzers.get(i).apiUsersCount;
        }
        long time2 = System.currentTimeMillis() - start2;

        // Вывод
        String result = "ERRORS: " + totalErrors + "\n/api/users: " + totalApi +
                "\nВремя (1 поток): " + time1 + " ms\nВремя (4 потока): " + time2 + " ms";
        System.out.println(result);

        FileWriter fw = new FileWriter("result_1.txt");
        fw.write(result);
        fw.close();
    }
}
