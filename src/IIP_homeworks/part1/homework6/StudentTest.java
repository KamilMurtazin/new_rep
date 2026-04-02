package IIP_homeworks.part1.homework6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private ArrayList<Student> students;
    private static final int STUDENT_COUNT = 100;
    private static final long SEED = 42;

    @BeforeEach
    public void setUp() {
        students = new ArrayList<>();
        Random random = new Random(SEED);

        String[] names = {"Kamil", "Amir", "Dinar", "Alexey", "Azamat", "Alexander", "Ivan", "Artem", "Daria", "Vika",
                "Pavel", "Mikhail", "Dmitry", "Ronaldo", "Messi", "Salavat", "Askar", "Said", "Jose", "Lamine", "Kylian",
                "Neymar", "Olise", "Harry", "Charles", "Samuel"};
        for (int i = 0; i < STUDENT_COUNT; i++) {
            String name = names[random.nextInt(names.length)] + " " + (i + 1);
            double rating = 50 + random.nextDouble() * 50;
            int missedClasses = random.nextInt(20);

            students.add(new Student(name, rating, missedClasses));
        }
    }

    @Test
    public void testComparable() {
        Collections.sort(students);
        int minMissedClasses = students.get(0).getMissedClasses();
        for (int i = 0; i < students.size(); i++) {
            assertTrue(students.get(i).getMissedClasses() >= minMissedClasses);
        }
        for (int i = 0; i < students.size() - 1; i++) {
            Student current = students.get(i);
            Student next = students.get(i + 1);
            if (current.getMissedClasses() == next.getMissedClasses()) {
                assertTrue(current.getRating() >= next.getRating());
            }
        }
        //для проверки
        for (int i = 0; i < 10; i++) {
            System.out.println(students.get(i));
        }
    }

    @Test
    public void testUtilityComparator() {
        Comparator<Student> utilityComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double score1 = o1.getRating() * 0.7 - o1.getMissedClasses() * 0.1;
                double score2 = o2.getRating() * 0.7 - o2.getMissedClasses() * 0.1;
                return Double.compare(score2, score1);
            }
        };

        students.sort(utilityComparator);
        for (int i = 0; i < students.size() - 1; i++) {
            Student current = students.get(i);
            Student next = students.get(i + 1);
            double currentScore = current.getRating() * 0.7 - current.getMissedClasses() * 0.1;
            double nextScore = next.getRating() * 0.7 - next.getMissedClasses() * 0.1;
            assertTrue(currentScore >= nextScore);
        }
    }

    @Test
    public void testIterator() {
        int originalSize = students.size();
        ArrayList<Student> badStudents = new ArrayList<>();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            //я изначально максимальный рейтинг брал 100, так что буду удалять студентов если баллов меньше 56
            if (s.getRating() < 56.0) {
                if (s.getMissedClasses() > 15) {
                    it.remove();
                } else {
                    badStudents.add(s);
                    it.remove();
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            assertTrue(students.get(i).getRating() >= 56.0);
        }
        int removedOrMoved = originalSize - students.size();
        assertEquals(removedOrMoved, badStudents.size() + (originalSize - students.size() - badStudents.size()));

        for (int i = 0; i < badStudents.size(); i++) {
            assertTrue(badStudents.get(i).getRating() < 56.0);
            assertTrue(badStudents.get(i).getMissedClasses() <= 15);
        }
    }
}