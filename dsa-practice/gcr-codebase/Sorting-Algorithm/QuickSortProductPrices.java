
import java.util.Arrays;

// Quick sort implementation for sorting product prices
public class QuickSortProductPrices {

    // Method to sort prices using quick sort algorithm
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Helper method to partition the array around pivot
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                swap(prices, i, j);
            }
        }

        swap(prices, i + 1, high);
        return i + 1;
    }

    // Helper method to swap two elements
    private static void swap(double[] prices, int i, int j) {
        double temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

    // Main method to test the quick sort
    public static void main(String[] args) {
        double[] productPrices = { 99.99, 25.50, 149.00, 75.25, 199.99, 45.80, 89.95, 120.00 };

        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}