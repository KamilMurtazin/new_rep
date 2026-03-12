package homework4;

public class MyArrayList<T> implements MyList<T> {
    private T[] array;
    private int size;
    protected static final int capacity = 10;

    public MyArrayList(){
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void grow(){ //увеличение массива
        int newCapacity = array.length * 3 / 2 ;
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void add(T item){
        if (size == array.length){
            grow();
        }
        array[size] = item;
        size ++;
    }

    @Override
    public void add(int index, T item){
        if (index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index > than size of list or < 0");
        }
        if (size == array.length){
            grow();
        }
        for (int i = size; i > index; i --){
            array[i] = array[i - 1];
        }
        array[index] = item;
        size ++;
    }

    @Override
    public T get(int index){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index > than size of list or < 0");
        }
        return array[index];
    }

    @Override
    public T remove(int index){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index >= than size of list or < 0");
        }
        T value = array[index];
        for (int i = index; i < size - 1; i ++){
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size --;
        return value;
    }

    @Override
    public boolean remove(T item){
        int ind = indexOf(item);
        if (ind >= 0 && ind < size){
            remove(ind);
            return true;
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

    @Override
    public void clear(){
        for (int i = 0; i < size; i ++){
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(T item){
        for (int i = 0; i < size; i ++){
            if (array[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T item){
        for (int i = 0; i < size; i ++){
            if (array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
}
