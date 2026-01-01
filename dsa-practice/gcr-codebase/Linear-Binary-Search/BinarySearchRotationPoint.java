// Binary search to find rotation point in rotated sorted array
public class BinarySearchRotationPoint {
    
    // Method to find rotation point (smallest element)
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // Main method to test rotation point search
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotationPoint = findRotationPoint(arr);
        
        System.out.println("Rotation point index: " + rotationPoint);
        System.out.println("Smallest element: " + arr[rotationPoint]);
    }
}