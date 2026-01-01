import java.util.Arrays;

// Selection sort implementation for sorting exam scores
public class SelectionSortExamScores {

    // Method to sort scores using selection sort algorithm
    public static void selectionSort(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(scores, i, minIndex);
            }
        }
    }

    // Helper method to swap two elements
    private static void swap(int[] scores, int i, int j) {
        int temp = scores[i];
        scores[i] = scores[j];
        scores[j] = temp;
    }

    // Main method to test the selection sort
    public static void main(String[] args) {
        int[] examScores = { 85, 92, 78, 96, 88, 73, 91, 82, 95, 87 };

        System.out.println("Original Exam Scores: " + Arrays.toString(examScores));

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores: " + Arrays.toString(examScores));
    }
}