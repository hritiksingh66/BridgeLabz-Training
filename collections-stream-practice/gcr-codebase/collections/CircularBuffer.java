public class CircularBuffer {
    private int[] buffer;
    private int head; // Points to oldest element
    private int tail; // Points to next insertion position
    private int size; // Current number of elements
    private int capacity; // Maximum buffer size
    
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    
    // Insert element, overwrite oldest if buffer is full
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Overwrite oldest
        }
    }
    
    // Display current buffer contents
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();
        
        cb.insert(4); // Should overwrite 1
        cb.display();
    }
}