package IIP_homeworks.part2.homework2_2.YandexGo;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private User user;
    private List<Product> products;
    private LocalDateTime orderDate;

    public Order(int id, User user, List<Product> products, LocalDateTime orderDate){
        this.id = id;
        this.user = user;
        this.products = products;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
