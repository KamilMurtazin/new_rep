package IIP_homeworks.part2.homework2_2.t2_2_2;

import java.util.List;

public class Order {
    private int id;
    private User user;
    private List<Product> products;

    public Order(int id, User user, List<Product> products){
        this.id = id;
        this.user = user;
        this.products = products;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
