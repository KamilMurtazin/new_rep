package IIP_homeworks.part3.classwork3_2;

import java.io.*;

public class Part4_Logs {
    public static void main(String[] args) throws IOException {
        FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Downloads\\session1.log");
        FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Downloads\\session2.log");

        SequenceInputStream sis = new SequenceInputStream(fis1, fis2);

        InputStreamReader isr = new InputStreamReader(sis);

        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
        isr.close();
        sis.close();
        fis1.close();
        fis2.close();
    }
}
