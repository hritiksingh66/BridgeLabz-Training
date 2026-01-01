
import java.util.*;

// Bubble sort implementation for sorting student marks
public class StudentMarksByBubbleSort {

  // Main method to input marks and sort them
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Read number of students and their marks
      int n = sc.nextInt();
      int[] marks = new int[n];
      for (int i = 0; i < n; i++) {
        marks[i] = sc.nextInt();
      }
      bubbleSort(marks);
      // Print sorted marks
      System.out.print("Sorted marks: ");
      for (int i = 0; i < n; i++) {
        System.out.print(marks[i] + " ");
      }
    }
  }

  // Method to sort marks using bubble sort algorithm
  private static void bubbleSort(int[] marks) {
    int n = marks.length;
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (marks[j] > marks[j + 1]) {
          int temp = marks[j];
          marks[j] = marks[j + 1];
          marks[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
  }
}