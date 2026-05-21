package IIP_homeworks.part5.classwork5_1;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Task1");
        printField(new Student("Misha", 19, "11-504", 4.5));

        System.out.println("Task2");
        Student s1 = new Student("Misha", 19, "11-504", 4.5);
        Student s2 = new Student("Misha", 19, "11-504", 4.5);
        Student s3 = new Student("Anya", 20, "11-451", 3.8);
        System.out.println(areEquals(s1, s2));
        System.out.println(areEquals(s1, s3));

        System.out.println("Task3");
        List<Student> students = List.of(
                new Student("Misha", 19, "11-504", 4.5),
                new Student("Anya", 20 ,"11-451", 3.8),
                new Student("Mira", 19, "11-312", 4.9)
        );
        try (FileWriter writer = new FileWriter("students.csv")) {
            for (Student s : students) {
                writer.write(toCsv(s) + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Task4");
        Student fromCsv = fromCsv("Misha,19,11-504,4.5");
        printField(fromCsv);

        System.out.println("Task5");
        List<Student> searchList = List.of(
                new Student("Misha", 19, "11-504", 4.5),
                new Student("Anya", 20, "11-451", 3.8),
                new Student("Mira", 19, "11-451", 4.9)
        );
        System.out.println("Найдено по group=11-451:");
        List<Object> result = findBy(searchList, "group", "11-451");
        for (Object obj : result) {
            printField(obj);
        }


        System.out.println("Task6");
        Student bad = new Student("", -1, null, 0.0);
        List<String> errors = validate(bad);
        System.out.println("Ошибки для bad студента:");
        for (String error : errors) {
            System.out.println(error);
        }
        Student good = new Student("Misha", 19, "11-504", 4.5);
        List<String> noErrors = validate(good);
        System.out.println("\nОшибки для good студента: " + noErrors);
    }

    //Task1
    public static void printField(Object object){
        Class<?> clas = object.getClass();
        Field[] fields = clas.getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " : " + field.get(object));
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }
    //Task2
    public static boolean areEquals(Object a, Object b){
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.getClass() != b.getClass()) return false;

        Class<?> clas = a.getClass();
        Field[] fields = clas.getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);
            try {
                Object valA = field.get(a);
                Object valB = field.get(b);
                if (!Objects.equals(valA, valB)){
                    return false;
                }
            } catch (IllegalAccessException e){
                return false;
            }
        }
        return true;
    }
    //Task3
    public static String toCsv(Object object){
        Class<?> clas = object.getClass();
        Field[] fields = clas.getDeclaredFields();
        List<String> values = new ArrayList<>();

        for (Field field : fields){
            field.setAccessible(true);
            try{
                values.add(String.valueOf(field.get(object)));
            } catch (IllegalAccessException e){
                values.add("");
            }
        }
        return String.join(",", values);
    }
    //Task4
    public static Student fromCsv(String line){
        try {

            String[] parts = line.split(",");

            Student student = new Student("", 0, "", 0.0);
            Class<?> clas = student.getClass();

            Field nameField = clas.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(student, parts[0]);

            Field ageField = clas.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(student, Integer.parseInt(parts[1]));

            Field groupField = clas.getDeclaredField("group");
            groupField.setAccessible(true);
            groupField.set(student, parts[2]);

            Field gpaField = clas.getDeclaredField("gpa");
            gpaField.setAccessible(true);
            gpaField.set(student, Double.parseDouble(parts[3]));

            return student;
        } catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
            return null;
        }
    }
    //Task5
    public static List<Object> findBy(List<?> list, String fieldName, Object value){
        List<Object> result = new ArrayList<>();

        for (Object object : list) {
            try {
                Class<?> clas = object.getClass();
                Field field = clas.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(object);

                if (Objects.equals(fieldValue, value)){
                    result.add(object);
                }
            } catch (NoSuchFieldException | IllegalAccessException e){

            }
        }
        return result;
    }
    //Task6
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                Class<?> type = field.getType();
                String fieldName = field.getName();

                if (type == String.class) {
                    String strValue = (String) value;
                    if (strValue == null || strValue.isEmpty()) {
                        errors.add(fieldName + " не должно быть пустым");
                    }
                }

                else if (type == int.class) {
                    int intValue = (int) value;
                    if (intValue <= 0) {
                        errors.add(fieldName + " должно быть > 0");
                    }
                }

                else if (type == double.class) {
                    double doubleValue = (double) value;
                    if (doubleValue <= 0) {
                        errors.add(fieldName + " должно быть > 0");
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add(field.getName() + ": ошибка доступа");
            }
        }
        return errors;
    }
}