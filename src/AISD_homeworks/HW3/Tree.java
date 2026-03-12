package AISD_homeworks.HW3;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int height;

    public Tree() {
        this.root = null;
        this.height = 0;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
        this.height = calculateHeight(root);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // рекурсивно вычисляем высоту дерева от указанного узла
    public int calculateHeight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight()));
    }

    public void add(T value) {
        TreeNode<T> node = new TreeNode<>(value);

        if (this.root == null) {
            this.root = node;
            this.height = 1;
        } else {
            add(this.root, value);
            // после добавления пересчитываем высоту
            this.height = calculateHeight(this.root);
        }
    }

    private void add(TreeNode<T> current, T value) {
        // если текущая нода больше вставляемого значения
        // проверяем, есть ли левый потомок
        // если нет, то добавляем нового потомка
        // если есть, вызываем рекурсивный метод снова
        // если текущая нода меньше вставляемого значения
        // проверяем, есть ли правый потомок и делаем все то же самое
        //
        if (current.getValue().compareTo(value) > 0) {
            if (current.getLeft() == null) {
                current.setLeft(new TreeNode<>(value));
            } else {
                add(current.getLeft(), value);
            }
        } else if (current.getValue().compareTo(value) <= 0) {
            if (current.getRight() == null) {
                current.setRight(new TreeNode<>(value));
            } else {
                add(current.getRight(), value);
            }
        }
    }

    // поиск значения в дереве
    public T get(T value) {
        if (this.root == null) {
            return null;
        }
        return get(root, value);
    }

    private T get(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            return get(node.getLeft(), value);
        } else if (cmp > 0) {
            return get(node.getRight(), value);
        } else {
            return node.getValue();
        }
    }

    // поиск минимального узла (самый левый)
    private TreeNode<T> findMin(TreeNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    // удаление значения из дерева
    public void remove(T value) {
        root = remove(root, value);
        // после удаления пересчитываем высоту
        height = calculateHeight(root);
    }

    private TreeNode<T> remove(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(remove(node.getLeft(), value));
        } else if (cmp > 0) {
            node.setRight(remove(node.getRight(), value));
        } else {
            // случай 1: нет потомков (лист)
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            // случай 2: только один потомок
            else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            // случай 3: два потомка
            else {
                TreeNode<T> minNode = findMin(node.getRight());
                node.setValue(minNode.getValue());
                node.setRight(remove(node.getRight(), minNode.getValue()));
            }
        }
        return node;
    }

    // прямой обход (корень -> левый -> правый)
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    // центрированный обход (левый -> корень -> правый)
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrder(node.getRight());
        }
    }

    // обратный обход (левый -> правый -> корень)
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(TreeNode<T> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }
}