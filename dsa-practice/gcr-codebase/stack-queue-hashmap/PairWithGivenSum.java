import java.util.HashSet;
import java.util.Set;

// Find pair of numbers in array that sum to target value
public class PairWithGivenSum {
    
    // Check if pair exists with given sum using HashSet
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            // Check if complement exists in set
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        
        return false;
    }
    
    // Find and return the pair with given sum
    public static int[] findPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return new int[]{complement, num};
            }
            seen.add(num);
        }
        
        return null;  // No pair found
    }
    
    // Test the pair sum algorithms
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        
        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        System.out.println("\nTarget sum: " + target);
        
        if (hasPairWithSum(arr, target)) {
            int[] pair = findPairWithSum(arr, target);
            System.out.println("Pair found: " + pair[0] + " + " + pair[1] + " = " + target);
        } else {
            System.out.println("No pair found");
        }
    }
}