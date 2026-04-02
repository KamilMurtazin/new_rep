package AISD_homeworks.semestrovka1;

public class Node<K extends Comparable<K>, V> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    public K key;
    public V value;
    public Node<K, V> left;
    public Node<K, V> right;
    public boolean color;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.color = RED;
    }
}