import java.util.Arrays;

// Challenge problems combining linear and binary search
public class ChallengeLinearBinarySearch {
    
    // Method to find first missing positive number
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Mark presence of numbers
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
    
    // Method to perform binary search for target
    public static int binarySearchTarget(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    // Main method to test challenge problems
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int[] sortedNums = {1, 3, 4, 6, 8, 10};
        int target = 6;
        
        // Find first missing positive
        int missingPositive = findFirstMissingPositive(nums.clone());
        System.out.println("First missing positive: " + missingPositive);
        
        // Binary search for target
        int targetIndex = binarySearchTarget(sortedNums, target);
        System.out.println("Target " + target + " found at index: " + targetIndex);
    }
}