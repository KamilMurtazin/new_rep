package IIP_homeworks.part3.classwork3_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task1_in_class {
    public static void main(String[] args) throws FileNotFoundException{

        String path = "C:\\Users\\User\\IdeaProjects\\MyFirstJavaProject\\src\\IIP_homeworks\\part3\\file_1.txt";

        BufferedReader br = null;

        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Message:" + e);
        }
        finally{
            if (br != null){
                try {
                    br.close();
                }
                catch (IOException e){
                    System.out.println("Ошибка при закрытии стрима");
                }
            }
        }
    }
}
