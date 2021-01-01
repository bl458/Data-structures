package ds; 

import java.util.*;

//Implementing a min heap
public class PQueue<T extends Comparable<T>> {
    private List<T> heap = null; 

    public PQueue() {this(1);}

    public PQueue(int sz) {heap = new ArrayList<>(sz);}
    
    //Create PQueue from array: O(n)
    public PQueue(T[] elems) {
        heap = new ArrayList<>(elems.length);
        for (T elem : elems) heap.add(elem);

        //Heapify O(n)
        //Start from idx of first non-leaf node going backwards
        for (int i=elems.length/2-1; i>=0; i--) 
            siftDown(i);
    }

    //Create PQueue from collection: O(n)
    public PQueue(Collection<T> elems) {
        heap = new ArrayList<>(elems.size());
        for (T elem : elems) heap.add(elem);
        for (int i=elems.size()/2-1; i>=0; i--) 
            siftDown(i);
    }

    public boolean isEmpty() {return size() == 0;}

    public void clear() {heap.clear();}

    public int size() {return heap.size();}
    
    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    //O(logn)
    public T poll() {
        return removeAt(0);
    }

    //O(n)
    public boolean contains(T elem) {
        for (T data: heap) 
            if (data.equals(elem)) return true;
        
        return false;
    }

    //O(logn)
    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException("Cannot add null");
        
        heap.add(elem);
        siftUp(size()-1);
    }

    //O(n)
    public boolean remove(T elem) {
        if (elem == null) throw new IllegalArgumentException("Cannot remove null");
        
        for (int i=0; i<size(); i++) {
            if (heap.get(i).equals(elem)) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    //For testing. Checks if k and below is min heap. (To check entire heap, input k=0)
    //O(n)
    public boolean isMinHeap(int k) {
        if (k>size()) return true;

        int child1 = k*2 + 1;
        int child2 = k*2 + 2;
        if (child1 < size() && less(child1, k)) return false; 
        if (child2 < size() && less(child2, k)) return false; 

        return isMinHeap(child1) && isMinHeap(child2);
    }

    public String toString() {
        return heap.toString();
    }

    private boolean less(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) < 0;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    //O(logn)
    private void siftUp(int k) {
        int parent = (k-1) / 2;
        
        //As long as k>0, parent is also valid 
        while (k>0 && less(k, parent)) {
            swap(parent, k);
            k = parent; 
            parent = (k-1) / 2;
        }
    }

    //O(logn)
    private void siftDown(int k) {
        int child1, child2, smallChild;
        
        while (true) {
            child1 = 2*k + 1;
            child2 = 2*k + 2;
            smallChild = child1;
            if (child2 < size() && less(child2, child1)) smallChild = child2;

            if (smallChild >= size() || less(k, smallChild)) break;
            
            swap(smallChild, k);
            k = smallChild;
        }
    }

    //O(logn)
    private T removeAt(int i) {
        T res = heap.get(i);
        int idxLastElement = heap.size()-1;
        swap(i, idxLastElement);
        heap.remove(idxLastElement);
        if (i == idxLastElement) return res;

        siftDown(i);
        return res;
    }
}
