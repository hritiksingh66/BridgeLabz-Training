
import java.util.Arrays;

// Counting sort implementation for sorting student ages
public class CountingSortStudentAges {

    // Method to sort ages using counting sort algorithm
    public static void countingSort(int[] ages) {
        int min = 10, max = 18;
        int range = max - min + 1;

        // Count array to store frequency of each age
        int[] count = new int[range];

        // Count frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Modify count array to store cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Output array
        int[] output = new int[ages.length];

        // Build output array from right to left for stability
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Copy output array to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Main method to test the counting sort
    public static void main(String[] args) {
        int[] studentAges = { 15, 12, 18, 14, 16, 10, 17, 13, 15, 11, 16, 14, 12, 18 };

        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));

        countingSort(studentAges);

        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}