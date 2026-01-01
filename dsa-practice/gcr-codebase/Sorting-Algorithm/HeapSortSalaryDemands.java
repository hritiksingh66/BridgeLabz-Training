
import java.util.Arrays;

// Heap sort implementation for sorting salary demands
public class HeapSortSalaryDemands {

    // Method to sort salaries using heap sort algorithm
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }

    // Helper method to maintain heap property
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }

    // Helper method to swap two elements
    private static void swap(int[] salaries, int i, int j) {
        int temp = salaries[i];
        salaries[i] = salaries[j];
        salaries[j] = temp;
    }

    // Main method to test the heap sort
    public static void main(String[] args) {
        int[] salaryDemands = { 75000, 95000, 60000, 120000, 85000, 45000, 110000, 70000 };

        System.out.println("Original Salary Demands: " + Arrays.toString(salaryDemands));

        heapSort(salaryDemands);

        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
    }
}