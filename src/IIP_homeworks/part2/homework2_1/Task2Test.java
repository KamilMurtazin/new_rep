package IIP_homeworks.part2.homework2_1;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class Task2Test {

    @Test
    public void testDiscount() {
        Map<String, Integer> products = new HashMap<>();
        products.put("Laptop", 100_000);
        products.put("Mouse", 5_000);
        products.put("Keyboard", 8_000);
        products.put("Smartphone", 50_000);

        int discount = 15;
        products.replaceAll((key, value) -> value - (value * discount / 100));
        products.forEach((key, value) -> System.out.println(key + ": " + value + "$"));
    }
}
