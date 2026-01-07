import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    // Push: Add to queue2, then move all from queue1 to queue2, swap queues
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // Swap queues to maintain LIFO order
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    // Pop: Remove from front of queue1 (most recent element)
    public int pop() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue1.poll();
    }
    
    // Top: Peek front of queue1
    public int top() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue1.peek();
    }
    
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
    }
}