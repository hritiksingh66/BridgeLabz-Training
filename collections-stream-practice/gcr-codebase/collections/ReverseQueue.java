import java.util.*;

public class ReverseQueue {
    
    // Reverse queue using auxiliary stack
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        // Move all elements to stack (LIFO)
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        
        // Move back to queue (reversed order)
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        
        System.out.println("Original queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed queue: " + queue);
    }
}