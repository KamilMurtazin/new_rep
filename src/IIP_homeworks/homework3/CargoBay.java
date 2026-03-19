package IIP_homeworks.homework3;

public class CargoBay<T> {
    private Object[] items;
    private int size;

    public CargoBay(int capacity){
        items = new Object[capacity];
        size = 0;
    }

    public void add(T item){
        if (size < items.length) {
            items[size] = item;
            size++;
        }
    }

    public T get(int index){
        return (T) items[index];
    }

    public Object[] getAll(){
        return items;
    }

    public int getSize() {
        return size;
    }
}
