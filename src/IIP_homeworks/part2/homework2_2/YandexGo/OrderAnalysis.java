package IIP_homeworks.part2.homework2_2.YandexGo;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalysis {
    public static void main(String[] args){
        Product product1 = new Product(1, "Laptop", 45_000);
        Product product2 = new Product(2, "iPhone", 70_000);
        Product product3 = new Product(3, "Keyboard", 5_000);
        Product product4 = new Product(4, "Energy Drink", 180);

        User user1 = new User(1, "Kamil");
        User user2 = new User(2, "Ronaldo");

        LocalDateTime now = LocalDateTime.now();
        Order order1 = new Order(1, user1, List.of(product2), now.minusDays(5));
        Order order2 = new Order(2, user2, List.of(product1, product3), now.minusDays(15));
        Order order3 = new Order(3, user1, List.of(product3), now.minusDays(81));
        Order order4 = new Order(4, user1, List.of(product4), now.minusDays(3));
        Order order5 = new Order(5, user2, List.of(product1, product4), now.minusDays(10));

        List<Product> allProducts = List.of(product1, product2, product3, product4);
        List<User> allUsers = List.of(user1, user2);
        List<Order> allOrders = List.of(order1, order2, order3, order4, order5);

        //Task1
        Set<Product> orderedProducts = allOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());

        System.out.println("What products have been ordered more than 1 time??");
        orderedProducts.forEach(product -> System.out.println(" - " + product.getName()));

        //Task2
        Map<Product, Long> productOrderCount = allOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));

        System.out.println("How many times have been ordered each product??");
        productOrderCount.forEach((product, count) -> System.out.println(" - " + product.getName() + " : " + count));

        //Task3


        //Task4
        Order biggestOrder = allOrders.stream()
                .max(Comparator.comparingInt(order -> order.getProducts().size()))
                .orElse(null);
        System.out.println("Biggest order ever??");
        System.out.println("Заказ (id): " + biggestOrder.getId());
        System.out.println("Кол-во товаров: " + biggestOrder.getProducts().size());

        //Task5


        //Task1 (H/W)
        LocalDateTime thirtyDaysAgo = now.minusDays(30);

        List<String> userNames = allOrders.stream()
                .filter(order -> order.getOrderDate().isAfter(thirtyDaysAgo))
                .filter(order -> order.getProducts().stream().anyMatch(product -> product.getName().equals("Energy Drink")))
                .map(Order::getUser)
                .map(User::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("What users bought Energy Drink last 30 days??");
        userNames.forEach(name -> System.out.println("  - " + name));

        //Task2 (H/W)
        Map<Product, Double> productRevenue = allOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(product -> product, Collectors.summingDouble(Product::getPrice)));
        Product mostProfitableProduct = productRevenue.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("Most profitable product??");
        System.out.println("  - " + mostProfitableProduct.getName());
        System.out.println("  -Revenue: " + productRevenue.get(mostProfitableProduct));

        //Task3 (H/W)
        System.out.println("Sorted by month and user");
        Map<Month, Map<User, Long>> ordersByMonthAndUser = allOrders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getOrderDate().getMonth(),

                        Collectors.groupingBy(
                                Order::getUser,

                                Collectors.counting()
                        )
                ));

        ordersByMonthAndUser.forEach((month, userMap) -> {
            System.out.println("Month: " + month);
            userMap.forEach((user, count) ->
                    System.out.println("   " + user.getName() + ": " + count + " orders(s)"));
        });

        //Task4 (H/W)
        System.out.println("Task4: User with above-average check");
        double totalRevenue = allOrders.stream()
                .mapToDouble(order -> order.getProducts().stream()
                        .mapToDouble(Product::getPrice)
                        .sum())
                .sum();
        long totalOrdersCount = allOrders.size();
        double averageCheckOverall = totalRevenue / totalOrdersCount;
        System.out.println("Average check overall: " + averageCheckOverall);

        Map<User, Double> userAverageCheck = allOrders.stream()
                .collect(Collectors.groupingBy(
                        Order::getUser,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                userOrders -> userOrders.stream()
                                        .mapToDouble(order -> order.getProducts().stream()
                                                .mapToDouble(Product::getPrice)
                                                .sum())
                                        .average()
                                        .orElse(0.0)
                        )
                ));

        List<User> aboveAverageUsers = userAverageCheck.entrySet().stream()
                .filter(entry -> entry.getValue() > averageCheckOverall)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("User(s) with above-average check:");
        aboveAverageUsers.forEach(user ->
                System.out.println("  - " + user.getName() + ": " + userAverageCheck.get(user)));

        //Task5 (H/W)
        System.out.println("Task5: Filtering Optionals");

        List<Optional<String>> labels = List.of(
                Optional.of("Apple"),
                Optional.empty(),
                Optional.of("banana"),
                Optional.of("Cherry"),
                Optional.of(""),
                Optional.of("Date")
        );

        List<String> filteredLabels = labels.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());

        System.out.println("Original labels: " + labels);
        System.out.println("Filtered labels: " + filteredLabels);
    }
}
