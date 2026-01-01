// Binary search to find peak element in array
public class BinarySearchPeakElement {
    
    // Method to find peak element using binary search
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // Main method to test peak element search
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int peakIndex = findPeakElement(arr);
        
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}