package IIP_homeworks.part1.homework5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    @Test
    public void timeTest() {
        String[] transactions = Generator.generateWithDuplicate(100000);

        long start1 = System.currentTimeMillis();
        String duplicate1 = DuplicateFinder.findDuplicateWithList(transactions);
        long time1 = System.currentTimeMillis() - start1;

        long start2 = System.currentTimeMillis();
        String duplicate2 = DuplicateFinder.findDuplicateWithSet(transactions);
        long time2 = System.currentTimeMillis() - start2;

        System.out.println("Метод 1 (MyArrayList): " + time1 + " мс");
        System.out.println("Метод 2 (MyHashSet): " + time2 + " мс");
        System.out.println("HashSet быстрее в " + (double)time1/time2 + " раз");

        assertEquals(duplicate1, duplicate2);
    }
}