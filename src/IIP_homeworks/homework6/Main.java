package IIP_homeworks.homework6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Kamil", 81, 5));
        students.add(new Student("Salikh", 57, 3));
        students.add(new Student("Amir", 75, 2));
        students.add(new Student("Timur", 69, 16));
        students.add(new Student("Ilya", 88, 1));
        students.add(new Student("Malik", 97, 9));
        students.add(new Student("Anton", 63, 12));

        System.out.println("Before using Comparable");
        for (int i = 0; i < students.size(); i ++){
            System.out.println(students.get(i));
        }

        System.out.println("After using Comparable");
        Collections.sort(students);
        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));

        }
        Comparator<Student> nameComparator = new Comparator<Student>(){
            @Override
            public int compare(Student st1, Student st2){
                return st1.getName().compareTo(st2.getName());
            }
        };
        students.sort(nameComparator);

        System.out.println("By alphabet (with using Comparator)");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student st = iterator.next();
            if (st.getMissedClasses() > 5){
                iterator.remove();
            }
        }

        System.out.println("After removing (with using Iterator)");
        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
    }
}
