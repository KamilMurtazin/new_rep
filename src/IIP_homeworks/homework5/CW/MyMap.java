package IIP_homeworks.homework5.CW;

public interface MyMap<K, V> {
    V put (K key, V value);
    V get(Object key);
    V remove(Object key);
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    int size();
    boolean isEmpty();
    void clear();
}
