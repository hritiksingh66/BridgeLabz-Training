import java.util.*;

// Performance comparison of search operations in different data structures
public class DataStructureSearchComparison {
    
    // Linear search method for arrays
    public static boolean arraySearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
    
    // Main method to compare search performance
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random random = new Random();
        
        for (int size : sizes) {
            // Create data
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            
            for (int i = 0; i < size; i++) {
                int value = random.nextInt(size * 2);
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }
            
            int target = array[size / 2];
            
            // Array search
            long startTime = System.nanoTime();
            arraySearch(array, target);
            long arrayTime = System.nanoTime() - startTime;
            
            // HashSet search
            startTime = System.nanoTime();
            hashSet.contains(target);
            long hashSetTime = System.nanoTime() - startTime;
            
            // TreeSet search
            startTime = System.nanoTime();
            treeSet.contains(target);
            long treeSetTime = System.nanoTime() - startTime;
            
            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search: " + (arrayTime / 1_000_000.0) + " ms");
            System.out.println("HashSet Search: " + (hashSetTime / 1_000_000.0) + " ms");
            System.out.println("TreeSet Search: " + (treeSetTime / 1_000_000.0) + " ms");
            System.out.println();
        }
    }
}