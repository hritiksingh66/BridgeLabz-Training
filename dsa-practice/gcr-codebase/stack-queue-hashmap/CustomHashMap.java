import java.util.LinkedList;

// Custom HashMap implementation using separate chaining for collision resolution
public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;  // Array of linked lists for collision handling
    private int size;  // Number of key-value pairs
    
    // Key-value pair entry
    static class Entry<K, V> {
        K key;
        V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // Initialize HashMap with default capacity
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }
    
    // Calculate hash index for a key
    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }
    
    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        // Check if key already exists and update value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        // Add new entry if key doesn't exist
        bucket.add(new Entry<>(key, value));
        size++;
    }
    
    // Get value for a key, return null if not found
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        
        return null;  // Key not found
    }
    
    // Remove key-value pair and return the value
    public V remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return entry.value;
            }
        }
        
        return null;  // Key not found
    }
    
    // Return number of key-value pairs
    public int size() {
        return size;
    }
    
    // Check if HashMap is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Test the custom HashMap implementation
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        
        // Add key-value pairs
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 8);
        
        // Test retrieval
        System.out.println("apple: " + map.get("apple"));
        System.out.println("banana: " + map.get("banana"));
        System.out.println("Size: " + map.size());
        
        // Test removal
        map.remove("banana");
        System.out.println("After removing banana, size: " + map.size());
        System.out.println("banana: " + map.get("banana"));
    }
}
