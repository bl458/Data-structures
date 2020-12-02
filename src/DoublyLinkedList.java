public class DoublyLinkedList<T> implements Iterable<T> {
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

        size++;
    }

    public void addLast(T elem) {
        if (isEmpty()) 
            head=tail=new Node<T>(elem, null, null);
        else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }

        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List");

        T data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) tail = null;
        else head.prev = null;
        
        return data; 
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        
        T data = tail.data;
        tail = tail.prev;
        size--;

        if (isEmpty()) head = null;
        else tail.next = null; 
        
        return data;
    }

    private T remove(Node<T> node) {
        if (node.prev == null) removeFirst();
        if (node.next == null) removeLast();

        T data = node.data;
        node.prev.next = null;
        node.next.prev = null; 
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        node.data = null;
        node.prev = node.next = node = null;
        size--;

        return data;
    }

    public T removeAt(int idx) {
        if (idx < 0 || idx >= size) throw new IllegalArgumentException("Index out of bounds");

        Node<T> trav;
        if (idx < size/2) {
            trav = head;
            for (int i=0; i!=idx; i++) 
                trav = trav.next;
        }
        else {
            trav = tail;
            for (int i=0; i!=idx; i++) 
                trav = trav.prev;
        }

        return remove(trav);
    }

    public boolean remove(Object obj) {
        Node<T> trav = head;
        for (int i=0; i<size; i++) {
            if (trav.data.equals(obj)) {
                remove(trav);
                return true;
            }
            trav = trav.next;
        }
        return false;
    }

    public int indexOf(Object obj) {
        Node<T> trav = head;
        for (int i=0; i<size; i++) {
            if (trav.data.equals(obj)) return i;
            trav = trav.next;
        }
        return -1;
    }

    public boolean contains(Object obj) {return indexOf(obj) != -1;}

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head; 
            @Override public boolean hasNext() {return trav.next != null;}
            @Override public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        if (size == 1) return "[" + head.data + "]";

        StringBuilder sb = new StringBuilder().append("[");
        Node<T> trav = head;
        for (int i=0; i<size; i++) {
            sb.append(trav.data);
            if (i != size) sb.append(", ");
        }

        return sb.append(']').toString();
    }
}
