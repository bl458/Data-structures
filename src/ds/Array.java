package ds; 

public class Array<T> implements Iterable<T> {
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public Array() {this(16);}

    public Array(int capacity) {
        if (capacity < 0) 
            throw new IllegalArgumentException("Illegal Capacity" + capacity);
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public void add(T element) {
        if (len+1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;

            T[] new_arr = (T[]) new Object[capacity];
            for (int i=0; i<len; i++) 
                new_arr[i] = arr[i];
            
            arr = new_arr;
        }
        
        arr[len++] = element;
    }

    public T removeAt(int idx) {
        if (idx >= len || idx < 0) throw new IndexOutOfBoundsException();
        
        T data = arr[idx];
        T[] new_arr = (T[]) new Object[len-1];
        for (int i=0, j=0; i<len; i++, j++) { 
            if (i == idx) j--;
            else new_arr[j] = arr[i];
        }
        
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public boolean remove(Object obj) {
        for (int i=0; i<len; i++) {
            if (obj.equals(arr[i])) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i=0; i<len; i++) {
            if (obj.equals(arr[i])) return i;
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) == -1;
    }

    @Override 
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;
            public boolean hasNext() { return index < len;}
            public T next() {return arr[index++];}
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        if (len == 1) return '[' + arr[0].toString() + ']';
        
        StringBuilder sb = new StringBuilder(len).append('[');
        for (int i=0; i<len; i++) {
            sb.append(arr[i]);
            if (i != len-1) sb.append(", ");
        }

        return sb.append(']').toString();
    }
}
