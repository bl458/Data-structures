import java.util.*;

class Entry<K, V> {
    int hash;
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    public boolean equals(Entry<K, V> other) {
        if (other.key.hashCode() != hash) return false;
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return key + " => " + value;
    }
}


public class HashTableSeparateChaining<K, V> implements Iterable<K> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList<Entry<K, V>>[] table;

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity");
        if (Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor) || maxLoadFactor <= 0) 
            throw new IllegalArgumentException("Illegal maxLoadFactor");

        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.maxLoadFactor = maxLoadFactor;
        this.threshold = (int)(this.capacity * this.maxLoadFactor);
        this.table = new LinkedList[this.capacity];
    }

    public int size() { return table.length; }

    public boolean isEmpty() { return size() == 0; }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean containsKey(K key) { return hasKey(key); }

    public boolean hasKey(K key) {
        int idx = normalizeIndex(key.hashCode());
        return bucketSeekEntry(idx, key) != null;
    }

    public V put(K key, V value) { return insert(key, value); }

    public V add(K key, V value) { return insert(key, value); }

    public V insert(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null key");

        int idx = normalizeIndex(key.hashCode());
        return bucketInsertEntry(idx, new Entry<K,V>(key, value));
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Null key");

        int idx = normalizeIndex(key.hashCode());
        Entry<K,V> entry = bucketSeekEntry(idx, key);
        if (entry != null) return entry.value;
        
        return null;
    }

    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("Null key");

        int idx = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(idx, key);
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>(capacity);
        for (LinkedList<Entry<K,V>> ll : table) {
            if (ll != null) 
                for (Entry<K,V> entry : ll) if (entry != null) keys.add(entry.key);
        }
        
        return keys;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>(capacity);
        for (LinkedList<Entry<K,V>> ll : table) {
            if (ll != null) 
                for (Entry<K,V> entry : ll) if (entry != null) values.add(entry.value);
        }
        
        return values;
    }

    private int normalizeIndex(int keyHash) { return Math.abs(keyHash) % capacity; }

    private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {}

    private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry) {}

    private V bucketRemoveEntry(int bucketIndex, K key) {}

    private void resizeTable() {}


}
