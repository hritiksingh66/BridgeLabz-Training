import java.util.Stack;

// Sort a stack using recursion without using extra data structures
public class SortStackRecursion {
    
    // Sort stack in ascending order (smallest on top)
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();  // Remove top element
            sortStack(stack);        // Recursively sort remaining stack
            insertSorted(stack, temp);  // Insert element in sorted position
        }
    }
    
    // Insert element in correct position in sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: stack empty or element is smaller than top
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();           // Remove top element
            insertSorted(stack, element);     // Recursively insert element
            stack.push(temp);                 // Put back the removed element
        }
    }
    
    // Test the stack sorting algorithm
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // Add unsorted elements
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);
        
        System.out.println("Original stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted stack: " + stack);
    }
}