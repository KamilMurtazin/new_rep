package IIP_homeworks.part3.classwork3_2;

import java.io.*;

public class Part2_Records {
    public static void main(String[] args){

        int[] scores = {198000, 190000, 181000, 89000, 71000};
        String[] nicknames = {"Havvrick", "Afl", "Khach", "Grizz", "Boch"};

        //запись
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("records.dat"));
            for (int i = 0; i < 5; i++){
                dos.writeInt(scores[i]);
                dos.writeUTF(nicknames[i]);
            }

            dos.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        //чтение
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("records.dat"));
            System.out.println("Top Records");
            for (int i = 0; i < 5; i++){
                int score = dis.readInt();
                String name = dis.readUTF();

                System.out.println("#" + (i + 1) + " " + score + " - "  + name);
            }
            dis.close();
        } catch (FileNotFoundException e){
            System.out.println("File didn't found");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
