import java.util.EmptyStackException;

public class Stack<T> implements Iterable<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    public Stack() {}

    public Stack(T firstElem) {push(firstElem);}

    public int size() {return list.size();}

    public boolean isEmpty() {return list.size() == 0;}

    public void push(T elem) {list.addLast(elem);}

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek() {return list.peekLast();}

    @Override
    public java.util.Iterator<T> iterator() {return list.iterator();}

    @Override
    public String toString() {return list.toString();}
}
