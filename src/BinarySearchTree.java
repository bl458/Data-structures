public class BinarySearchTree<T extends Comparable<T>> {
    private int nodeCount = 0;
    private Node root = null;
    
    private class Node {}

    public int size() {}

    public boolean isEmpty() {}

    public boolean add(T elem) {}

    private Node add(Node node, T elem) {}

    public boolean remove(T elem) {}

    private Node remove(Node node, T elem) {}

    private Node findMin(Node node) {}

    public boolean contains(T elem) {}

    private boolean contains(Node node, T elem) {}

    public int height() {}

    private int height(Node node) {}

    public java.util.Iterator<T> traverse(TreeTraversalOrder order) {}

    private java.util.Iterator<T> preOrderTraversal() {}

    private java.util.Iterator<T> inOrderTraversal() {}

    private java.util.Iterator<T> postOrderTraversal() {}

    private java.util.Iterator<T> levelOrderTraversal() {}
}
