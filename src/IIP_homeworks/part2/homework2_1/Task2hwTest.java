package IIP_homeworks.part2.homework2_1;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class Task2hwTest {

    @Test
    public void testStringClean() {
        Function<String, String> trimmer = s -> s.trim();
        Function<String, String> toLower = s -> s.toLowerCase();
        Function<String, String> firstUpper = s -> s.substring(0, 1).toUpperCase() + s.substring(1);

        Function<String, String> fullClean = trimmer.andThen(toLower).andThen(firstUpper);
        Function<String, String> quickClean = trimmer.andThen(toLower);

        String dirtyName = "  iVaN_iVaNoV  ";

        String fullCleaned = fullClean.apply(dirtyName);
        String quickCleaned = quickClean.apply(dirtyName);

        System.out.println("Исходная строка: " + dirtyName);
        System.out.println("fullClean: " + fullCleaned);
        System.out.println("quickClean: " + quickCleaned);

        assert fullCleaned.equals("Ivan_ivanov");
        assert quickCleaned.equals("ivan_ivanov");
    }
}
