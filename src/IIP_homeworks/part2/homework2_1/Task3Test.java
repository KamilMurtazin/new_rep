package IIP_homeworks.part2.homework2_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Task3Test {

    @Test
    public void testTaxCalculation(){
        Function<Integer, Function<Integer, Integer>> taxCalculator = taxRate -> basePrice -> basePrice + (basePrice * taxRate / 100);
        Function<Integer, Integer> ruTax = taxCalculator.apply(20);
        Function<Integer, Integer> usTax = taxCalculator.apply(10);

        List<Integer> prices = new ArrayList<>(Arrays.asList(100,500,1000));

        System.out.println("Prices with tax in RU");
        prices.forEach(price -> System.out.println(price + " -> " + ruTax.apply(price) + " rub"));

        System.out.println("Prices with tax in US");
        prices.forEach(price -> System.out.println(price + " -> " + usTax.apply(price) + " $"));
     }
}