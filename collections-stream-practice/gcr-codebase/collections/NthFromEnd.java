import java.util.*;

public class NthFromEnd {
    
    // Find Nth element from end using two-pointer technique
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || list.isEmpty()) return null;
        
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        
        // Move first pointer n steps ahead
        for (int i = 0; i < n && first.hasNext(); i++) {
            first.next();
        }
        
        // Move both pointers until first reaches end
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        
        return second.hasNext() ? second.next() : null;
    }
    
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        
        System.out.println("List: " + list);
        System.out.println("2nd from end: " + findNthFromEnd(list, 2));
        System.out.println("3rd from end: " + findNthFromEnd(list, 3));
    }
}