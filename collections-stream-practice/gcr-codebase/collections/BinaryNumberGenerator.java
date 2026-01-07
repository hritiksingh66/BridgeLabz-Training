import java.util.*;

public class BinaryNumberGenerator {
    
    // Generate first N binary numbers using BFS approach
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("1"); // Start with "1"
        
        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            result.add(current);
            
            // Generate next level: append "0" and "1"
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int n = 5;
        List<String> binaryNumbers = generateBinaryNumbers(n);
        
        System.out.println("First " + n + " binary numbers: " + binaryNumbers);
    }
}