package homework5;

public class Node<K,V> {
    K key;
    V value;
    Node<K,V> next;

    public Node(K key, V value, Node<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
