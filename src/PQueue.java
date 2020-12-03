import java.util.*;

public class PQueue<T extends Comparable<T>> {
    private int heapSize = 0;
    private int heapCapacity = 0;
    private List<T> heap = null; 
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PQueue() {}

    public PQueue(int sz) {}
    
    public PQueue(T[] elems) {}

    public PQueue(Collection<T> elems) {}

    public boolean isEmpty() {}

    public void clear() {}

    public int size() {}

    public T peek() {}

    public T poll() {}

    public boolean contains(T elem) {}

    public void add(T elem) {}

    public boolean remove(T elem) {}

    //For testing. Checks if k and below is min heap. (To check entire heap, input k=0)
    public boolean isMinHeap(int k) {}

    public String toString() {}

    private boolean less(int i, int j) {}

    private void swap(int i, int j) {}

    private void siftUp(int k) {}

    private void siftDown(int k) {}

    private T removeAt(int i) {}

    private void mapAdd(T value, int idx) {}

    private void mapRemove(T value, int idx) {}

    private Integer mapGet(T value) {}

    private void mapSwap(T val1, T val2, int val1Idx, int val2Idx) {}
}
