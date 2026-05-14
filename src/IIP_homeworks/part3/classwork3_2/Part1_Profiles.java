package IIP_homeworks.part3.classwork3_2;

import java.io.*;

public class Part1_Profiles {
    public static void main(String[] args){

        PlayerProfile p1 = new PlayerProfile("Havvrick", 21, 181000, true);
        PlayerProfile p2 = new PlayerProfile("Dinero", 17, 179000, false);
        PlayerProfile p3 = new PlayerProfile("Afl", 29, 201000, true);

        //запись
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("profile.dat"))){
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
        } catch (IOException e){
            e.printStackTrace();
        }
        //чтение
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("profiles.dat"))){
            while (true){
                try {
                    PlayerProfile p = (PlayerProfile) ois.readObject();
                    System.out.println(p);
                } catch (IOException e){
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
