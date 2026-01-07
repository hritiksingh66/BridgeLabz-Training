import java.util.*;

public class RemoveDuplicates {
    
    // Remove duplicates while preserving order using HashSet
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (Integer element : list) {
            if (seen.add(element)) { // add() returns true if element is new
                result.add(element);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> unique = removeDuplicates(numbers);
        
        System.out.println("Input: " + numbers);
        System.out.println("Without duplicates: " + unique);
    }
}