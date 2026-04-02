package AISD_homeworks.semestrovka1;

public class RBTree<K extends Comparable<K>, V> {
    private Node<K, V> root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public V get(K key) {
        Node<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node<K, V> get(Node<K, V> node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        if (cmp > 0) return get(node.right, key);
        return node;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = Node.BLACK;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    public void remove(K key) {
        if (!contains(key)) return;
        if (!isRed(root.left) && !isRed(root.right)) root.color = Node.RED;
        root = delete(root, key);
        if (root != null) root.color = Node.BLACK;
        size--;
    }

    private Node<K, V> delete(Node<K, V> node, K key) {
        if (key.compareTo(node.key) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left)) node = moveRedLeft(node);
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left)) node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && node.right == null) return null;
            if (!isRed(node.right) && !isRed(node.right.left)) node = moveRedRight(node);
            if (key.compareTo(node.key) == 0) {
                Node<K, V> min = min(node.right);
                node.key = min.key;
                node.value = min.value;
                node.right = deleteMin(node.right);
            } else {
                node.right = delete(node.right, key);
            }
        }
        return balance(node);
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left == null) return node.right;
        if (!isRed(node.left) && !isRed(node.left.left)) node = moveRedLeft(node);
        node.left = deleteMin(node.left);
        return balance(node);
    }

    private Node<K, V> min(Node<K, V> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node<K, V> moveRedLeft(Node<K, V> h) {
        flipColors(h);
        if (h.right != null && isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private Node<K, V> moveRedRight(Node<K, V> h) {
        flipColors(h);
        if (h.left != null && isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    private Node<K, V> balance(Node<K, V> h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (h.left != null && isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }

    private boolean isRed(Node<K, V> node) {
        return node != null && node.color == Node.RED;
    }

    private Node<K, V> rotateLeft(Node<K, V> h) {
        Node<K, V> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Node.RED;
        return x;
    }

    private Node<K, V> rotateRight(Node<K, V> h) {
        Node<K, V> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Node.RED;
        return x;
    }

    private void flipColors(Node<K, V> h) {
        h.color = Node.RED;
        if (h.left != null) h.left.color = Node.BLACK;
        if (h.right != null) h.right.color = Node.BLACK;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}