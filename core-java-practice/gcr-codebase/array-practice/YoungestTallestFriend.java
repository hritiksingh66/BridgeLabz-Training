import java.util.Scanner;

// Program to find youngest and tallest friend from a group of 3 friends
public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Arrays to store friend data
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Input age and height for each friend
        System.out.println("Enter age and height for 3 friends:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }
        
        // Find youngest and tallest friend indices
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        for (int i = 1; i < 3; i++) {
            // Find youngest friend (minimum age)
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            // Find tallest friend (maximum height)
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        // Display results
        System.out.println("\nResults:");
        System.out.println("Youngest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + ")");
        
        sc.close();
    }
}
