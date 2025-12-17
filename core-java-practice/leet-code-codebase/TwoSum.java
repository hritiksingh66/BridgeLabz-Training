import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Method to find indices of two numbers whose sum equals target
    public static int[] twoSum(int[] nums, int target) {

        // Map to store number and its index
        Map<Integer, Integer> mp = new HashMap<>();

        // Array to store answer indices
        int[] ans = new int[2];

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {

            // Find remaining value needed
            int remaining = target - nums[i];

            // Check if remaining value exists in map
            if (mp.containsKey(remaining)) {
                ans[0] = mp.get(remaining);
                ans[1] = i;
                return ans; // solution found
            }

            // Store current number and its index
            mp.put(nums[i], i);
        }

        return ans; // return result
    }

    // Main method for user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target value
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // Call twoSum method
        int[] result = twoSum(nums, target);

        // Display result
        System.out.println("Indices are: " + result[0] + " " + result[1]);

        sc.close();
    }
}
