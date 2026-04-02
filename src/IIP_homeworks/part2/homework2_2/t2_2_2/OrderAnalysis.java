package IIP_homeworks.part2.homework2_2.t2_2_2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderAnalysis {
    public static void main(String[] args){
        Product product1 = new Product(1, "Laptop");
        Product product2 = new Product(2, "iPhone");
        Product product3 = new Product(3, "Keyboard");

        User user1 = new User(1, "Kamil");
        User user2 = new User(2, "Ronaldo");

        Order order1 = new Order(1, user1, List.of(product2));
        Order order2 = new Order(2, user2, List.of(product1, product3));
        Order order3 = new Order(3, user1, List.of(product3));

        List<Product> allProducts = List.of(product1, product2, product3);
        List<User> allUsers = List.of(user1, user2);
        List<Order> allOrders = List.of(order1, order2, order3);

        //Task1
        Set<Product> orderedProducts = allOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());

        orderedProducts.forEach(product -> System.out.println(" - " + product.getName()));

        //Task2
        Map<Product, Long> productOrderCount = allOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));

        productOrderCount.forEach((product, count) -> System.out.println(" - " + product.getName() + " : " + count));

        //Task3


        //Task4
        Order biggestOrder = allOrders.stream()
                .max(Comparator.comparingInt(order -> order.getProducts().size()))
                .orElse(null);
        System.out.println("Заказ (id): " + biggestOrder.getId());
        System.out.println("Кол-во товаров: " + biggestOrder.getProducts().size());

        //Task5

    }
}
