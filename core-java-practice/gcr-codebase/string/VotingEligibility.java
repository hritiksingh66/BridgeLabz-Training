import java.util.Random;

// Program to check voting eligibility using random ages
public class VotingEligibility {

    // Generate random ages for testing
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        
        // Generate ages between 10-99
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }

    // Check voting eligibility for each age
    public static String[][] checkEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            
            // Check eligibility (18+ can vote)
            if (ages[i] < 0) {
                result[i][1] = "false"; // Invalid age
            } else if (ages[i] >= 18) {
                result[i][1] = "true";  // Eligible to vote
            } else {
                result[i][1] = "false"; // Too young to vote
            }
        }
        return result;
    }

    // Display eligibility results in table format
    public static void displayEligibility(String[][] data) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        // Generate and check eligibility for 10 random ages
        int[] ages = generateAges(10);
        String[][] eligibility = checkEligibility(ages);
        displayEligibility(eligibility);
    }
}
