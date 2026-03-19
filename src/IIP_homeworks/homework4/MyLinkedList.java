package IIP_homeworks.homework4;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T item){
        if (head == null){
            head = new Node<>(item);
        } else {
            Node<T> node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node<>(item);
        }
        size++;
    }
    @Override
    public void add(int index, T item){
        if (index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index > than size of list or < 0");
        }
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> before = head;
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
        int counter = 0;
        Node<T> node = head;
        while (counter < index){
            node = node.next;
            counter++;
        }
        return node.data;
    }
    @Override
    public T remove(int index){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index >= than size of list or < 0");
        }
        T deletedItem;
        if (index == 0){
            deletedItem = head.data;
            head = head.next;
        } else {
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i ++){
                previous = previous.next;
            }
            Node<T> toDelete = previous.next;
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
        Node<T> node = head;
        if (head.data.equals(item)){
            head = head.next;
            size--;
            return true;
        }
        while (node.next != null){
            if (node.next.data.equals(item)){
                node.next = node.next.next;
                size --;
                return true;
            }
            node = node.next;
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
        size = 0;
    }
    @Override
    public boolean contains(T item){
        Node<T> node = head;
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
        Node<T> node = head;
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