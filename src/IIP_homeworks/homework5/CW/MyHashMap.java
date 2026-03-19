package IIP_homeworks.homework5.CW;

public class MyHashMap<K,V> implements MyMap<K,V> {
    private int size;
    public static final int capacity = 16;
    private Node<K,V>[] buckets;

    public MyHashMap(){
        buckets = (Node<K,V>[]) new Node[capacity];
        size = 0;
    }

    private int getBucketIndex(Object key){
        return Math.abs(key.hashCode() % buckets.length);
    }

    @Override
    public V put(K key, V value){
        if (size >= buckets.length) {
            resize();
        }
        
        int index = getBucketIndex(key);
        Node<K,V> current = buckets[index];

        while (current != null){
            if (current.key.equals(key)){
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }

        Node<K,V> newNode = new Node<K, V>(key, value, buckets[index]);
        buckets[index] = newNode;
        size++;
        return null;
    }

    @Override
    public V get(Object key){
        int index = getBucketIndex(key);
        Node<K,V> current = buckets[index];

        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public V remove(Object key){
        int index = getBucketIndex(key);
        Node<K,V> current = buckets[index];
        Node<K,V> prev = null;

        while (current != null){
            if (current.key.equals(key)){
                if (prev == null){
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size --;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key){
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value){
        for (int i = 0; i < buckets.length; i++){
            Node<K,V> current = buckets[i];
            while (current != null){
                if (current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        buckets = (Node<K,V>[]) new Node[capacity];
        size = 0;
    }

    private void resize() {
        Node<K,V>[] oldBuckets = buckets;
        buckets = (Node<K,V>[]) new Node[oldBuckets.length * 2];
        size = 0;

        for (int i = 0; i < oldBuckets.length; i++) {
            Node<K,V> current = oldBuckets[i];
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
}
