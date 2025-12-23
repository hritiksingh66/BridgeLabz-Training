public class RandomNumberAnalyzer {
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return randomNumbers;
    }
    
    public static double[] findAverageMinMax(int[] nums) {
        if (nums.length == 0) {
            return new double[0];
        }
        
        double sum = 0;
        int min = nums[0];
        int max = nums[0];
        
        for (int number : nums) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        double average = sum / nums.length;
        return new double[]{average, min, max};
    }
    
    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        
        System.out.println("Generated 4-digit random numbers:");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println("Number " + (i + 1) + ": " + randomNumbers[i]);
        }
        
        double[] results = findAverageMinMax(randomNumbers);
        
        System.out.println("\nAnalysis Results:");
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
}
