// Linear search to find first negative number
public class LinearSearchFirstNegative {
    
    // Method to find first negative number in array
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
    
    // Main method to test linear search for negative number
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, -2, 7, -1, 4};
        int index = findFirstNegative(arr);
        
        if (index != -1) {
            System.out.println("First negative number found at index: " + index + " (value: " + arr[index] + ")");
        } else {
            System.out.println("No negative number found");
        }
    }
}