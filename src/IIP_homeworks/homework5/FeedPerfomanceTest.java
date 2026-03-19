package IIP_homeworks.homework5;

import IIP_homeworks.homework4.MyArrayList;
import IIP_homeworks.homework4.MyDoubleLinkedList;
import IIP_homeworks.homework4.MyList;

public class FeedPerfomanceTest {

    public static void generateFeed(MyList<String> list, int amount){
        for (int i = 0; i < amount; i++){
            list.add(0, "News #" + i);
        }
    }

    public static void main(String[] args){
        int amount = 100_000;

        //test with MyArrayList
        MyList<String> arrayList = new MyArrayList<>();
        long start1 = System.currentTimeMillis();
        generateFeed(arrayList, amount);
        long time1 = System.currentTimeMillis() - start1;
        System.out.println("MyArrayList: " + time1 + " мс");

        //test with MyDoubleLinkedList
        MyDoubleLinkedList<String> doubleLinkedList = new MyDoubleLinkedList<>();
        long start2 = System.currentTimeMillis();
        generateFeed(doubleLinkedList, amount);
        long time2 = System.currentTimeMillis() - start2;
        System.out.println("MyDoubleLinkedList: " + time2 + " мс");
    }
}
