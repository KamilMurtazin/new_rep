package IIP_homeworks.part3.classwork3_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\IdeaProjects\\MyFirstJavaProject\\src\\IIP_homeworks\\part3\\classwork3_1\\students.csv";

        List<Student> students = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            reader.readLine();

            while((line = reader.readLine()) != null){
                String[] arr = line.split(",");
                students.add(new Student(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3]));
            }
        } catch (IOException e){
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println();

        Map<String, Long> list2 = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));
        System.out.println(list2);
    }
}
