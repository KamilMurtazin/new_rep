package IIP_homeworks.part2.homework2_1;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class Task3hwTest {

    @Test
    public void testCommentFilter(){
        Predicate<String> isShort = s -> s.length() < 5;
        Predicate<String> hasSpam = s -> s.contains("buy");
        Predicate<String> isCaps = s -> s.equals(s.toUpperCase());

        Predicate<String> notShort = isShort.negate();
        Predicate<String> capsOrSpam = isCaps.or(hasSpam);
        Predicate<String> complexRule = notShort.and(capsOrSpam);

        //test
        checkComment("Hello", complexRule);
        checkComment("BUY NOW", complexRule);
        checkComment("buy cheap", complexRule);
        checkComment("Hi", complexRule);
        checkComment("GOOD MORNING", complexRule);
        checkComment("I like this", complexRule);
        checkComment("BUY", complexRule);
        checkComment("ok", complexRule);
    }
    public static void checkComment(String text, Predicate<String> rule) {
        if (rule.test(text)) {
            System.out.println("Комментарий: " + text + " - Удалено");
        } else {
            System.out.println("Комментарий: " + text + " - Одобрено");
        }
    }
}
