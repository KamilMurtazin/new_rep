package IIP_homeworks.homework2.classwork2;

public class Box<T extends Number> {
    private T value;

    public Box(T value){
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
