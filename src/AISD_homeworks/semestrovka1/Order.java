package AISD_homeworks.semestrovka1;

public class Order {
    public int id;
    public String customer;
    public String product;
    public String status;

    public Order(int id, String customer, String product) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.status = "Новый";
    }

    public String toString() {
        return "#" + id + " | " + customer + " | " + product + " | " + status;
    }
}