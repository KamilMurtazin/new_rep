package IIP_homeworks.part2.homework2_2.t2_2_1;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){


        List<Student> students = List.of(
                new Student("Аня", 19, "Java", 4.5, List.of("Теннис", "Кино")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")),
                new Student("Борис", 19, "Java", 4.9, List.of("Кино", "Чтение")),
                new Student("Света", 21, "C++", 4.0, List.of("Музыка", "Игры")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")));
        //Task1
        students.stream()
                .skip(1)
                .limit(3)
                .filter(student -> student.getAge() < 19)
                .map(Student::getName)
                .forEach(System.out::println);

        long count = students.stream()
                .filter(student -> student.getAge() > 19)
                .count();
        System.out.println(count);
        //Task2
        List<String> languages = students.stream()
                .map(Student::getLanguage)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(languages);

        languages.stream()
                .forEach(System.out::println);
        //Task3
        boolean hasJava = students.stream().anyMatch(student -> student.getLanguage().equals("Java"));
        boolean allAdults = students.stream().allMatch(student -> student.getAge() > 18);
        boolean noLosers = students.stream().noneMatch(student -> student.getRating() > 3.0);

        System.out.println(hasJava);
        System.out.println(allAdults);
        System.out.println(noLosers);
        //Task4
        Set<String> hobbies = students.stream()
                .flatMap(student -> student.getHobbies().stream())
                .collect(Collectors.toSet());
        System.out.println(hobbies);

        Map<String, List<Student>> mapByLanguage = students.stream()
                .collect(Collectors.groupingBy(Student::getLanguage));

        System.out.println(mapByLanguage);

        String line = students.stream()
                .filter(student -> student.getRating() > 4.0)
                .map(Student::getName)
                .collect(Collectors.joining(", ", "Наши отличники: ", "! Ну красавчики!"));

        System.out.println(line);
        //Task5
        Optional<Student> perfectStudent = students.stream()
                .filter(student -> student.getRating() == 5.0)
                .findFirst();

        perfectStudent.ifPresent(student -> System.out.println(student.getName()));

        String studentName = perfectStudent
                .map(Student::getName)
                .orElse("Студент не найден");

        System.out.println("Имя студента: " + studentName);
    }
}
