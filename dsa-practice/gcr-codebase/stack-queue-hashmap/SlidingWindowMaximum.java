import java.util.ArrayDeque;
import java.util.Deque;

// Find maximum element in each sliding window of size k
public class SlidingWindowMaximum {
    
    // Find maximum in each sliding window using deque
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();  // Store indices
        
        for (int i = 0; i < n; i++) {
            // Remove indices outside current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove indices of smaller elements from rear
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);  // Add current index
            
            // Store result when window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    // Test the sliding window maximum algorithm
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        
        System.out.println("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        
        System.out.println("\nSliding window maximum (k=" + k + "): ");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}
