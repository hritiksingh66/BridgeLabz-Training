import java.util.Stack;

// Implement queue using two stacks
public class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue operations
    private Stack<Integer> stack2; // For dequeue operations
    
    // Initialize both stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Add element to rear of queue
    public void enqueue(int x) {
        stack1.push(x);
    }
    
    // Remove and return element from front of queue
    public int dequeue() {
        // Move elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    // Return front element without removing it
    public int peek() {
        // Move elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // Test the queue implementation
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        
        // Add elements to queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        // Remove and display elements (FIFO order)
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());   // 2
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3
    }
}