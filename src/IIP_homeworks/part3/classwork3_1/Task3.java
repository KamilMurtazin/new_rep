package IIP_homeworks.part3.classwork3_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args){
        String inputPath = "C:\\Users\\User\\IdeaProjects\\MyFirstJavaProject\\src\\IIP_homeworks\\part3\\classwork3_1\\cat.jpg";
        String outputPath = "C:\\Users\\User\\IdeaProjects\\MyFirstJavaProject\\src\\IIP_homeworks\\part3\\classwork3_1\\cat-copy.jpeg";

        try {
            FileInputStream input = new FileInputStream(inputPath);
            FileOutputStream output = new FileOutputStream(outputPath);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1){
                output.write(buffer, 0, bytesRead);
            }

            input.close();
            output.close();

            System.out.println("Image has been copied successfully");
        } catch (IOException e){
            System.out.println("Mistake: " + e.getMessage());
        }
    }
}
