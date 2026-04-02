package IIP_homeworks.part1.homework5;

import IIP_homeworks.part1.homework5.CW.MyHashSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {

    @Test
    public void testHashCodeChange() {
        MyHashSet<Visitor> visitors = new MyHashSet<>();
        Visitor vasily = new Visitor("Василий", "123");

        visitors.add(vasily);
        assertTrue(visitors.contains(vasily));

        vasily.setPassId("999");

        boolean result = visitors.contains(vasily);
        assertFalse(result);

        /*
        РЕЗУЛЬТАТ: false
        ПОЧЕМУ: hashCode() изменился после изменения passId,
        поэтому contains() ищет в другой корзине и не находит
        */
    }
}