public class DoublyLinkedList<T> implements Iterable {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        } 

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public boolean isEmpty() {return size == 0;}

    public void add(T elem) {addLast(elem);}

    public void addFirst(T elem) {
        if (isEmpty()) 
            head=tail=new Node<T>(elem, null, null);
        else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }

        size += 1;
    }

    public void addLast(T elem) {
        if (isEmpty()) 
            head=tail=new Node<T>(elem, null, null);
        else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }

        size += 1;
    }
}
