// Program to analyze football team heights with random data generation
public class FootballTeamHeights {
    
    // Generate random heights for 11 players (150-250 cm)
    public static int[] generateRandomHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150; // 150-250 cm
        }
        return heights;
    }
    
    // Calculate sum of all heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    
    // Calculate mean height
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }
    
    // Find shortest height
    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }
    
    // Find tallest height
    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }
    
    public static void main(String[] args) {
        // Generate random heights for team
        int[] heights = generateRandomHeights();
        
        // Display individual player heights
        System.out.println("Football Team Heights (in cms):");
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i] + " cm");
        }
        
        // Display analysis results
        System.out.println("\nAnalysis Results:");
        System.out.println("Shortest height: " + findShortest(heights) + " cm");
        System.out.println("Tallest height: " + findTallest(heights) + " cm");
        System.out.println("Mean height: " + String.format("%.2f", findMean(heights)) + " cm");
        System.out.println("Sum of all heights: " + findSum(heights) + " cm");
    }
}
