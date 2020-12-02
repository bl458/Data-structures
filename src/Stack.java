public class Stack<T> implements Iterable<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    public Stack() {}

    public Stack(T firstElem) {}

    public int size() {}

    public boolean isEmpty() {}

    public void push(T elem) {}

    public T pop() {}

    public T peek() {}

    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}
