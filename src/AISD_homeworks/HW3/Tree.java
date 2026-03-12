package AISD_homeworks.HW3;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int height;

    public Tree() {
       this.height = 0;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
        this.height = 1;
    }

    public int getHeight() {
        return height;
    }

    public void add(T value) {
        TreeNode<T> node = new TreeNode<>(value);

        if (this.root == null) {
            this.root = node;
            this.height = 1;
        } else {
            add(this.root, value, 1);
        }
    }

    private void add(TreeNode<T> current, T value, int level) {
        if (current.getValue().compareTo(value) > 0) {
            if (current.getLeft() == null) {
                TreeNode<T> newNode = new TreeNode<>(value,current);
                current.setLeft(newNode);

                int newLevel = level + 1;
                if (newLevel > this.height){
                    this.height = newLevel;
                }
            } else {
                add(current.getLeft(), value, level + 1);
            }
        } else if (current.getValue().compareTo(value) <= 0) {
            if (current.getRight() == null) {
                TreeNode<T> newNode = new TreeNode<>(value, current);
                current.setRight(newNode);

                int newLevel = level + 1;
                if (newLevel > this.height){
                    this.height = newLevel;
                }
            } else {
                add(current.getRight(), value, level + 1);
            }
        }
    }
}