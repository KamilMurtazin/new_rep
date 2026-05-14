package IIP_homeworks.part3.classwork3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Part3_Card {
    public static void main(String[] args) throws IOException{
        //запсись
        StringWriter sw = new StringWriter();

        sw.write("Карточка игрока\n");
        sw.write("Ник: ShadowKnight\n");
        sw.write("Уровень: 42\n");
        sw.write("Счёт: 198400\n");
        sw.write("Статус: Online\n");

        String card = sw.toString();
        sw.close();

        //чтение
        StringReader reader = new StringReader(card);
        BufferedReader br = new BufferedReader(reader);

        String line;
        int lineNum = 1;
        while ((line = br.readLine()) != null) {
            System.out.println(lineNum + ": " + line);
            lineNum++;
        }
        reader.close();
    }
}
