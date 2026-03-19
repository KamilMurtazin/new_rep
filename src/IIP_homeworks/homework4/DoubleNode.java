package IIP_homeworks.homework4;

public class DoubleNode<E> {
    E data;
    DoubleNode<E> next;
    DoubleNode<E> prev;

    public DoubleNode(E data, DoubleNode<E> next, DoubleNode<E> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode(E data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
