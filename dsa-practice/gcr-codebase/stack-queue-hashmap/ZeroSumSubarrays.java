import java.util.*;

// Find all subarrays with sum equal to zero
public class ZeroSumSubarrays {
    
    // Find all zero sum subarrays using prefix sum and HashMap
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();  // prefix sum -> list of indices
        int sum = 0;  // Running prefix sum
        
        // Add initial sum 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // Update prefix sum
            
            // If this sum has been seen before, we found zero sum subarrays
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i});  // Add subarray indices
                }
            }
            
            // Add current sum and index to map
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        
        return result;
    }
    
    // Test the zero sum subarrays algorithm
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> subarrays = findZeroSumSubarrays(arr);
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Zero sum subarrays:");
        for (int[] subarray : subarrays) {
            System.out.println("From index " + subarray[0] + " to " + subarray[1]);
        }
    }
}