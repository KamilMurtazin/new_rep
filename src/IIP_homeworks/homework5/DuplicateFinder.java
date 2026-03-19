package IIP_homeworks.homework5;
import IIP_homeworks.homework4.MyArrayList;
import IIP_homeworks.homework5.CW.MyHashSet;

public class DuplicateFinder {
    public static String findDuplicateWithList(String[] transactions){
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i < transactions.length; i++){
            String current = transactions[i];

            if (list.contains(current)){
                return current;
            }

            list.add(current);
        }
        return null;
    }

    public static String findDuplicateWithSet(String[] transactions){
        MyHashSet<String> set = new MyHashSet<>();

        for (int i = 0; i < transactions.length; i++){
            String current = transactions[i];

            if (set.contains(current)){
                return current;
            }

            set.add(current);
        }
        return null;
    }
}
