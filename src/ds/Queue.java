package ds; 

public class Queue<T> implements Iterable<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    public Queue() {}
    
    public Queue(T firstElem) {offer(firstElem);}

    public int size() {return list.size();}

    public boolean isEmpty() {return list.size() == 0;}

    public void offer(T elem) {list.addLast(elem);}

    public T peek() {return list.peekFirst();}

    public T poll() {return list.removeFirst();}

    @Override
    public java.util.Iterator<T> iterator() {return list.iterator();}
}   
