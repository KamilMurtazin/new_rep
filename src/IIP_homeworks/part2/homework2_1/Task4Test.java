package IIP_homeworks.part2.homework2_1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {
    @Test
    public void testFilterList() {
        List<Integer> numbers = Arrays.asList(1, -5, 10, -20, 33);

        List<Integer> positiveNumbers = ListUtils.filterList(numbers, n -> n > 0);

        List<Integer> expected = Arrays.asList(1, 10, 33);
        assertEquals(expected, positiveNumbers);
    }
}
