import java.util.Scanner;

// Program to calculate mean height of football team players
public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array to store heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0;
        
        // Input heights of all players
        System.out.println("Enter heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }
        
        // Calculate sum of all heights
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        
        // Calculate mean height
        double mean = sum / 11;
        
        // Display result
        System.out.println("\nMean height of the football team: " + mean);
        
        sc.close();
    }
}
