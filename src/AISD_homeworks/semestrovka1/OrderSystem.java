package AISD_homeworks.semestrovka1;

public class OrderSystem {
    private RBTree<Integer, Order> tree;
    private int nextId;

    public OrderSystem() {
        tree = new RBTree<>();
        nextId = 1;
    }

    public int addOrder(String customer, String product) {
        int id = nextId++;
        tree.put(id, new Order(id, customer, product));
        return id;
    }

    public Order findOrder(int id) {
        return tree.get(id);
    }

    public boolean removeOrder(int id) {
        if (!tree.contains(id)) return false;
        tree.remove(id);
        return true;
    }

    public int size() {
        return tree.size();
    }
}