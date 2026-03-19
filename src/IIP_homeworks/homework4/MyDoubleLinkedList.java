package IIP_homeworks.homework4;

public class MyDoubleLinkedList<T> implements MyList<T>{
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public MyDoubleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item){
        DoubleNode<T> newNode = new DoubleNode<>(item);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    @Override
    public void add(int index, T item){//не успел сделать
        if (index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index > than size of list or < 0");
        }
        DoubleNode<T> newNode = new DoubleNode<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            DoubleNode<T> before = head;
            for (int i = 0; i < index - 1; i++){
                before = before.next;
            }
            newNode.next = before.next;
            before.next = newNode;
        }
        size++;
    }
    @Override
    public T get(int index){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index >= than size of list or < 0");
        }

        DoubleNode<T> node;

        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node.data;
    }
    @Override
    public T remove(int index){//не успел сделать
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index >= than size of list or < 0");
        }
        T deletedItem;
        if (index == 0){
            deletedItem = head.data;
            head = head.next;
        } else {
            DoubleNode<T> previous = head;
            for (int i = 0; i < index - 1; i ++){
                previous = previous.next;
            }
            DoubleNode<T> toDelete = previous.next;
            deletedItem = toDelete.data;
            previous.next = toDelete.next;
        }
        size --;
        return deletedItem;
    }
    @Override
    public boolean remove(T item){
        if (head == null) {
            return false;
        }
        DoubleNode<T> current = head.next;
        if (head.data.equals(item)){
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
            return true;
        }

        while (current != null){
            if (current.data.equals(item)){
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size --;
                return true;
            }
            current = current.next;
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
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public boolean contains(T item){
        DoubleNode<T> node = head;
        while (node != null){
            if (node.data.equals(item)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    @Override
    public int indexOf(T item){
        DoubleNode<T> node = head;
        int index = 0;
        while (node != null){
            if (node.data.equals(item)){
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }
}
