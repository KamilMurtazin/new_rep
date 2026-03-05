package AISD_homeworks.HW2;

public class Stack {
    private StackNode top;
    private int size;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public void add(StackNode node) {
        node.setPrevious(this.top);
        this.top = node;
        this.size++;
    }

    public StackNode remove() {
        if (this.top == null) {
            return null;
        }
        StackNode result = this.top;
        this.top = this.top.getPrevious();
        this.size--;
        return result;
    }

    public int getSize() {
        return this.size;
    }
}