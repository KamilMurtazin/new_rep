package IIP_homeworks.part2.homework2_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task1Test {  // нужен класс-обертка!

    @Test
    public void test1() {  // метод должен быть внутри класса, @Test над методом
        List<String> list = new ArrayList<>(Arrays.asList("Admin", "Q", "Boba", "12", "SuperUser"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() < 4) {
                iterator.remove();
            }
        }
        List<String> mylist = new ArrayList<>(Arrays.asList("Admin", "Boba", "SuperUser"));
        assertEquals(mylist, list);  // без Assertions.
        assertEquals(3, list.size());
    }

    @Test
    public void lambdaTest1() {
        List<String> list = new ArrayList<>(Arrays.asList("Admin", "Q", "Boba", "12", "SuperUser"));
        list.removeIf(login -> login.length() < 4);
        list.forEach(login -> System.out.println(login));

        assertFalse(list.contains("Q"));  // без Assertions.
        assertEquals(3, list.size());
    }
}