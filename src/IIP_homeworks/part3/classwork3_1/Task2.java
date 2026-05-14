package IIP_homeworks.part3.classwork3_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Task2 {
    public static void main(String[] args){

        String inputPath = "C:\\Users\\User\\IdeaProjects\\MyFirstJavaProject\\src\\IIP_homeworks\\part3\\classwork3_1\\numbers.txt";
        String outputPath = "C:\\Users\\User\\IdeaProjects\\MyFirstJavaProject\\src\\IIP_homeworks\\part3\\classwork3_1\\stats.txt";

        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> lineSums = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            String line;
            int lineNumbers = 1;

            while ((line = reader.readLine()) != null){
                String[] parts = line.split(" ");
                int lineSum = 0;

                for (String part : parts){
                    if (!part.isEmpty()){
                        int num = Integer.parseInt(part);
                        allNumbers.add(num);
                        lineSum += num;
                    }
                }

                lineSums.add(lineSum);
                lineNumbers++;
            }

            if (allNumbers.isEmpty()){
                System.out.println("File is empty");
                return;
            }

            int count = allNumbers.size();
            int sum = 0;
            int min = allNumbers.get(0);
            int max = allNumbers.get(0);

            for (int num : allNumbers) {
                sum += num;
                if (num < min) min = num;
                if (num > max) max = num;
            }

            double avg = (double) sum / count;

            PrintWriter writer = new PrintWriter(new FileWriter(outputPath));
            writer.println("count=" + count);
            writer.println("sum=" + sum);
            writer.println("min=" + min);
            writer.println("max=" + max);
            writer.println("avg=" + avg);

            for (int i = 0; i < lineSums.size(); i++) {
                writer.println("line " + (i + 1) + ": sum=" + lineSums.get(i));
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
