package IIP_homeworks.part2.homework2_1;

import org.junit.jupiter.api.Test;
import java.util.function.Consumer;
import java.util.function.Function;

public class Task1hwTest {

    public static Function<String, Function<String, Consumer<String>>> createNotifier() {
        return token -> chatId -> message -> {
            System.out.println("Sending notification to Telegram:");
            System.out.println("  Token: " + token);
            System.out.println("  ChatId: " + chatId);
            System.out.println("  Message: " + message);
        };
    }

    public static void processOrder(String item, Consumer<String> sender) {
        System.out.println("Processing order: " + item);
        sender.accept("Your order " + item + " has been placed successfully!");
        System.out.println();
    }

    @Test
    public void testProcessOrder() {
        Consumer<String> myNotifier = createNotifier().apply("token").apply("chatId");

        processOrder("Laptop", myNotifier);
        processOrder("Mouse", myNotifier);
    }
}
